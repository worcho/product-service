package plant_shop.product_service.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long id;
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    @PositiveOrZero(message = "Price must be greater than zero.")
    private BigDecimal price;

}
