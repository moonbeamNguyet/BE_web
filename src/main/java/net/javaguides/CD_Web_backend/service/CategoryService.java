package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.CategoryDto;
import net.javaguides.CD_Web_backend.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategorys();
}
