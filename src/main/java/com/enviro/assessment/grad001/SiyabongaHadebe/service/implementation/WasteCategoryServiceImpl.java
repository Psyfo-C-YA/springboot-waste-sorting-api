package com.enviro.assessment.grad001.SiyabongaHadebe.service.implementation;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.DuplicateResourceException;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.RequestValidationException;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.SiyabongaHadebe.mapper.WasteCategoryDTOMapper;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import com.enviro.assessment.grad001.SiyabongaHadebe.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.WasteCategoryRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing waste categories.
 */
@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private WasteCategoryDTOMapper wasteCategoryDTOMapper;

    /**
     * Retrieves all waste categories.
     * @return a list of waste categories.
     */
    @Override
    public List<WasteCategoryDTO> findAllWasteCategories() {
        return wasteCategoryRepository.findAll().stream().map(wasteCategoryDTOMapper).collect(Collectors.toList());
    }

    /**
     * Retrieves a waste category by its ID.
     * @param id the ID of the waste category.
     * @return an Optional containing the waste category if found, or empty if not.
     */
    @Override
    public WasteCategoryDTO findWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .map(wasteCategoryDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "waste category with id [%s] not found".formatted(id)
                ));
    }

    @Override
    public WasteCategoryDTO findWasteCategoryByName(String name) {
        return wasteCategoryRepository.findWasteCategoryByName(name)
                .map(wasteCategoryDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "waste category with name [%s] not found".formatted(name)
                ));
    }

    /**
     * Create a new waste category.
     *
     * @param wasteCategoryRequest the waste category to save.
     */
    @Override
    public void createWasteCategory(WasteCategoryRequest wasteCategoryRequest) {
        // Check if category exists
        String name = wasteCategoryRequest.name();
        if (wasteCategoryRepository.existsWasteCategoryByName(name)) {
            throw new DuplicateResourceException(
                    "waste category name already exists"
            );
        }

        // Create
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName(name);
        wasteCategoryRepository.save(wasteCategory);
    }



    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to delete.
     */
    @Override
    public void deleteWasteCategory(Long id) {
        checkIfCategoryExistsOrThrow(id);
        wasteCategoryRepository.deleteById(id);
    }

    private void checkIfCategoryExistsOrThrow(Long categoryId) {
        if (!wasteCategoryRepository.existsWasteCategoryById(categoryId)) {
            throw new ResourceNotFoundException(
                    "waste category with id [%s] not found".formatted(categoryId)
            );
        }
    }

    @Override
    public void updateWasteCategory(Long id, WasteCategoryRequest wasteCategoryRequest) {
        WasteCategory category = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("waste category with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if (wasteCategoryRequest.name() != null && !wasteCategoryRequest.name().equals(category.getName())) {
            category.setName(wasteCategoryRequest.name());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        wasteCategoryRepository.save(category);
    }

}
