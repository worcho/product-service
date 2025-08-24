package plant_shop.product_service.servicies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_shop.product_service.common.DtoEntityMapper;
import plant_shop.product_service.controllers.dtos.ProductDto;
import plant_shop.product_service.models.ProductEntity;
import plant_shop.product_service.repositories.ProductRepository;
import plant_shop.product_service.servicies.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto create(ProductDto product) {
        ProductEntity productEntity = productRepository.save(DtoEntityMapper.convertToEntity(product));
        return DtoEntityMapper.convertToDto(productEntity);
    }
}
