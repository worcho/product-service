package plantShop.product.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Price cannot be empty.")
    private BigDecimal price;

}
