package plant_shop.product_service.service;

import plant_shop.product_service.controller.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto product);

    List<ProductDto> getAll();

    ProductDto getById(Long id);
}
