package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.CategoryDto;
import net.javaguides.CD_Web_backend.entity.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto (Category category){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getImage(),
                category.getActive(),
                category.getActiveHome()
        );
    }
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getImage(),
                categoryDto.getActive(),
                categoryDto.getActiveHome()
        );
    }

}
