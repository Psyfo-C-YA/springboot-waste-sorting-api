package com.enviro.assessment.grad001.SiyabongaHadebe.controller;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.RecyclingTipRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing recycling tips.
 */
@RestController
@RequestMapping("/api/recycling-tips")
@Validated
public class RecyclingTipController {

    // Injects the RecyclingTipService dependency
    @Autowired
    private RecyclingTipService recyclingTipService;

    // Handles GET requests to retrieve all recycling tips
    @GetMapping
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        return recyclingTipService.findAllRecyclingTips();
    }

    // Handles GET requests to retrieve a recycling tip by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(@PathVariable Long id) {
        return ResponseEntity.ok(recyclingTipService.findRecyclingTipById(id));
    }

    // Handles POST requests to create a new recycling tip
    @PostMapping("{wasteCategoryId}")
    public void createRecyclingTip(
            @RequestBody @Validated RecyclingTipRequest recyclingTipRequest ,
            @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        recyclingTipService.createRecyclingTip(recyclingTipRequest, wasteCategoryId);
    }

    // Handles PUT requests to update an existing recycling tip
    @PutMapping("{id}/tip/{wasteCategoryId}")
    public void updateRecyclingTip(@PathVariable("id") Long id,
                                                    @RequestBody @Validated RecyclingTipRequest recyclingTipRequest,
                                                    @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        recyclingTipService.updateRecyclingTip(id,recyclingTipRequest,wasteCategoryId);
    }

    // Handles DELETE requests to delete a recycling tip by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }

}
