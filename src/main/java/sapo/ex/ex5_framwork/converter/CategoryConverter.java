package sapo.ex.ex5_framwork.converter;

import org.modelmapper.ModelMapper;
import sapo.ex.ex5_framwork.dto.CategoryDto;
import sapo.ex.ex5_framwork.model.CategoryEntity;

public class CategoryConverter {
    public CategoryDto converDto(CategoryEntity categoryEntity) {
        ModelMapper mapper = new ModelMapper();
        CategoryDto categoryDto = mapper.map(categoryEntity, CategoryDto.class);
        return categoryDto;

    }

    public CategoryEntity converEntty(CategoryDto categoryDto) {
        ModelMapper mapper = new ModelMapper();
        CategoryEntity entity = mapper.map(categoryDto, CategoryEntity.class);
        return entity;

    }
}
