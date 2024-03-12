package com.novmah.productservice.service;

import com.novmah.basedomains.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    List<CategoryDto> findAll();
    CategoryDto update(CategoryDto categoryDto);
    void deleteById(Integer id);

}
