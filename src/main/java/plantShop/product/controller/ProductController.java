package plantShop.product.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plantShop.product.controller.dtos.ProductDto;
import plantShop.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.ok()
                .body(productService.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(productService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok()
                .body(productService.getAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateById(@PathVariable Long id, @Valid @RequestBody ProductDto dto){
        return ResponseEntity.ok()
                .body(productService.updateById(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
