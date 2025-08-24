package plant_shop.product_service.common;

import plant_shop.product_service.controllers.dtos.ProductDto;
import plant_shop.product_service.models.ProductEntity;

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
