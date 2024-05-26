package com.enviro.assessment.grad001.SiyabongaHadebe.controller;


import com.enviro.assessment.grad001.SiyabongaHadebe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.WasteCategoryRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.implementation.WasteCategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing waste categories.
 */
@RestController
@RequestMapping("/api/waste-categories")
@Validated
public class WasteCategoryController {

    @Autowired
    private WasteCategoryServiceImpl wasteCategoryService;

    /**
     * Retrieves all waste categories.
     * @return a list of waste categories.
     */
    @GetMapping
    public List<WasteCategoryDTO> getAllCategories() {
        return wasteCategoryService.findAllWasteCategories();
    }


    /**
     * Retrieves a waste category by its ID.
     * @param id the ID of the waste category.
     * @return the waste category, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.findWasteCategoryById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<WasteCategoryDTO> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(wasteCategoryService.findWasteCategoryByName(name));
    }

    /**
     * Creates a new waste category.
     * @param wasteCategoryRequest the waste category to create.
     * @return the created waste category.
     */
    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createCategory(@Valid @RequestBody WasteCategoryRequest wasteCategoryRequest) {
        wasteCategoryService.createWasteCategory(wasteCategoryRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategoryRequest wasteCategoryRequest) {
        wasteCategoryService.updateWasteCategory(id, wasteCategoryRequest);
        return ResponseEntity.ok().build();
    }

    /**
     * Deletes a waste category by its ID.
     * @param id the ID of the waste category to delete.
     * @return 204 No Content if successful, 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }


}