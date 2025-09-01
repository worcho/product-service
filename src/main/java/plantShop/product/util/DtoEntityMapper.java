package plantShop.product.util;

import plantShop.product.controller.dtos.ProductDto;
import plantShop.product.entity.ProductEntity;

public class DtoEntityMapper {

    public static ProductEntity convertToEntity(ProductDto dto){
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public static ProductDto convertToDto(ProductEntity entity){
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
