package plantShop.product.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantShop.product.entity.ProductEntity;
import plantShop.product.exception.ProductNotFoundException;
import plantShop.product.util.DtoEntityMapper;
import plantShop.product.controller.dtos.ProductDto;
import plantShop.product.repository.ProductRepository;
import plantShop.product.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto product) {
        return DtoEntityMapper.convertToDto(productRepository.save(DtoEntityMapper.convertToEntity(product)));
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(DtoEntityMapper::convertToDto)
                .toList();
    }

    @Override
    public ProductDto getById(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return DtoEntityMapper.convertToDto(productEntity);
    }

    @Override
    @Transactional
    public ProductDto updateById(Long id, ProductDto dto) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return DtoEntityMapper.convertToDto(productEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        boolean exists = productRepository.existsById(id);
        if (exists){
            productRepository.deleteById(id);
        }else {
            throw new ProductNotFoundException(("Product not found with id: " + id));
        }
    }
}
