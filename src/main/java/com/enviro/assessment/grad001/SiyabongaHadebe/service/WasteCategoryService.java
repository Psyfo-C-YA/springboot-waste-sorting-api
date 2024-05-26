package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.WasteCategoryRequest;

import java.util.List;

public interface WasteCategoryService {
    List<WasteCategoryDTO> findAllWasteCategories();
    WasteCategoryDTO findWasteCategoryById(Long id);
    WasteCategoryDTO findWasteCategoryByName(String name);
    void createWasteCategory(WasteCategoryRequest wasteCategoryRequest);
    void deleteWasteCategory(Long id);
    void updateWasteCategory(Long id, WasteCategoryRequest wasteCategoryRequest);
}
