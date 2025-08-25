package plant_shop.product_service.service.impl;

import org.springframework.stereotype.Service;
import plant_shop.product_service.common.DtoEntityMapper;
import plant_shop.product_service.controllers.dtos.ProductDto;
import plant_shop.product_service.repositories.ProductRepository;
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
        return productRepository.findById(id)
                .map(DtoEntityMapper::convertToDto)
                .orElse(null);
    }
}
