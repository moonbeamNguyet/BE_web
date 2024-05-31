package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.CategoryDto;
import net.javaguides.CD_Web_backend.entity.Category;
import net.javaguides.CD_Web_backend.mapper.CategoryMapper;
import net.javaguides.CD_Web_backend.repository.CategoryRepository;
import net.javaguides.CD_Web_backend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(saveCategory);
    }

    @Override
    public List<CategoryDto> getAllCategorys() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(java.util.stream.Collectors.toList());
    }
}
