package sapo.ex.ex5_framwork.converter;

import org.modelmapper.ModelMapper;
import sapo.ex.ex5_framwork.dto.ProductDto;
import sapo.ex.ex5_framwork.model.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {
    ModelMapper mapper = new ModelMapper();
    public ProductDto converDto(ProductEntity productEntity) {

        ProductDto productDto = mapper.map(productEntity, ProductDto.class);
        return productDto;

    }

    public ProductEntity converEntty(ProductDto productDto) {

        ProductEntity entity = mapper.map(productDto, ProductEntity.class);
        return entity;

    }
    public Iterable<ProductDto> converEntty(Iterable<ProductEntity> entities){
        List<ProductDto> productDtos=new ArrayList<>();
        for (ProductEntity entity: entities){
            productDtos.add(mapper.map(entity,ProductDto.class));
        }
    return productDtos; }
}

