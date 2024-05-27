package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.WasteCategoryRequest;

import java.util.List;

// Interface defining the methods for category services
public interface WasteCategoryService {

    // Method to get all categories
    List<WasteCategoryDTO> findAllWasteCategories();

    // Method to get a category by ID
    WasteCategoryDTO findWasteCategoryById(Long id);

    // Method to get a category by name
    WasteCategoryDTO findWasteCategoryByName(String name);

     // Method to create a new category
    void createWasteCategory(WasteCategoryRequest wasteCategoryRequest);

    // Method to delete a category by ID
    void deleteWasteCategory(Long id);

    // Method to update a category
    void updateWasteCategory(Long id, WasteCategoryRequest wasteCategoryRequest);
}
