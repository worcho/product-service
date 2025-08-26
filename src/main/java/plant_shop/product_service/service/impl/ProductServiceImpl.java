package plant_shop.product_service.service.impl;

import org.springframework.stereotype.Service;
import plant_shop.product_service.entity.ProductEntity;
import plant_shop.product_service.exception.ProductNotFoundException;
import plant_shop.product_service.util.DtoEntityMapper;
import plant_shop.product_service.controller.dtos.ProductDto;
import plant_shop.product_service.repository.ProductRepository;
import plant_shop.product_service.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
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
}
