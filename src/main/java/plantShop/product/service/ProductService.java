package plantShop.product.service;

import plantShop.product.controller.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto product);

    List<ProductDto> getAll();

    ProductDto getById(Long id);
}
