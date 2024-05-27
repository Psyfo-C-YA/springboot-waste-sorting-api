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

    // Injects the WasteCategoryService dependency
    @Autowired
    private WasteCategoryServiceImpl wasteCategoryService;

    // Handles GET requests to retrieve all waste categories
    @GetMapping
    public List<WasteCategoryDTO> getAllCategories() {
        return wasteCategoryService.findAllWasteCategories();
    }

    // Handles GET requests to retrieve a waste category by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.findWasteCategoryById(id));
    }

    // Handles GET requests to retrieve a waste category by name
    @GetMapping("/name/{name}")
    public ResponseEntity<WasteCategoryDTO> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(wasteCategoryService.findWasteCategoryByName(name));
    }

    // Handles POST requests to create a new waste category
    @PostMapping
    public ResponseEntity<WasteCategoryDTO> createCategory(@Valid @RequestBody WasteCategoryRequest wasteCategoryRequest) {
        wasteCategoryService.createWasteCategory(wasteCategoryRequest);
        return ResponseEntity.ok().build();
    }

    // Handles PUT requests to update an existing waste category
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategoryRequest wasteCategoryRequest) {
        wasteCategoryService.updateWasteCategory(id, wasteCategoryRequest);
        return ResponseEntity.ok().build();
    }

    // Handles DELETE requests to delete a waste category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
