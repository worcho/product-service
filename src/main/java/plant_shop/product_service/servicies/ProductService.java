package plant_shop.product_service.servicies;

import org.springframework.stereotype.Service;
import plant_shop.product_service.controllers.dtos.ProductDto;

@Service
public interface ProductService {

    ProductDto create(ProductDto product);
}
