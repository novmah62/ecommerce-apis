package com.novmah.productservice.mapper;

import com.novmah.basedomains.dto.CategoryDto;
import com.novmah.productservice.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "parentCategory", target = "parentCategoryDto", qualifiedByName = "mapParentCategory")
    CategoryDto map(Category category);

    @Mapping(source = "parentCategoryDto", target = "parentCategory", qualifiedByName = "mapParentCategoryDto")
    Category map(CategoryDto categoryDto);

    @Named("mapParentCategory")
    static CategoryDto mapParentCategory(Category parentCategory) {
        if (parentCategory != null) {
            return CategoryDto.builder()
                    .id(parentCategory.getId())
                    .name(parentCategory.getName())
                    .description(parentCategory.getDescription())
                    .build();
        }
        return null;
    }

    @Named("mapParentCategoryDto")
    static Category mapParentCategoryDto(CategoryDto parentCategoryDto) {
        if (parentCategoryDto != null) {
            return Category.builder()
                    .id(parentCategoryDto.getId())
                    .name(parentCategoryDto.getName())
                    .description(parentCategoryDto.getDescription())
                    .build();
        }
        return null;
    }

}
