package plant_shop.product_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plant_shop.product_service.controllers.dtos.ProductDto;
import plant_shop.product_service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductDto> create (@RequestBody ProductDto dto){
        return ResponseEntity.ok()
                .body(productService.create(dto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok()
                .body(productService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){
        return ResponseEntity.ofNullable(productService.getById(id));
    }
}
