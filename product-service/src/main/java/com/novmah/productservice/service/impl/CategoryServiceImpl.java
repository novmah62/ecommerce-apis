package com.novmah.productservice.service.impl;

import com.novmah.basedomains.dto.CategoryDto;
import com.novmah.productservice.exception.ResourceNotFoundException;
import com.novmah.productservice.mapper.CategoryMapper;
import com.novmah.productservice.domain.Category;
import com.novmah.productservice.repository.CategoryRepository;
import com.novmah.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Optional.ofNullable(categoryDto.getParentCategoryDto()).ifPresent(parentCategoryDto -> {
            if (!categoryRepository.existsById(parentCategoryDto.getId()))
                throw new ResourceNotFoundException(
                        "Category", "parent category ID", parentCategoryDto.getId());
        });
        Category category = categoryRepository.save(mapper.map(categoryDto));
        return mapper.map(category);
    }

    @Override
    public CategoryDto findById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category ID", id));
        return mapper.map(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(mapper::map).distinct().toList();
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        if (!categoryRepository.existsById(categoryDto.getId())) {
            throw new ResourceNotFoundException("Category", "category ID", categoryDto.getId());
        }
        Optional.ofNullable(categoryDto.getParentCategoryDto()).ifPresent(parentCategoryDto -> {
            if (!categoryRepository.existsById(parentCategoryDto.getId()))
                throw new ResourceNotFoundException(
                        "Category", "parent category ID", parentCategoryDto.getId());
        });
        Category category = categoryRepository.save(mapper.map(categoryDto));
        return mapper.map(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
