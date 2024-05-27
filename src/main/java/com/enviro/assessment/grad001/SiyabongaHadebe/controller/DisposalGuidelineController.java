package com.enviro.assessment.grad001.SiyabongaHadebe.controller;


import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing disposal guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
@Validated
public class DisposalGuidelineController {

    // Injects the DisposalGuidelineService dependency
    @Autowired
    private DisposalGuidelineService  disposalGuidelineService;

    // Handles GET requests to retrieve all disposal guidelines
    @GetMapping
    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return disposalGuidelineService.findAllDisposalGuidelines();
    }

    // Handles GET requests to retrieve a disposal guideline by ID
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(disposalGuidelineService.findDisposalGuidelineById(id));
    }

    // Handles POST requests to create a new disposal guideline
    @PostMapping("/{wasteCategoryId}")
    public void createDisposalGuideline(@RequestBody @Validated DisposalGuidelineRequest disposalGuidelineRequest, @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        disposalGuidelineService.createDisposalGuideline(disposalGuidelineRequest, wasteCategoryId);
    }

    // Handles PUT requests to update an existing disposal guideline
    @PutMapping("{id}/guideline/{wasteCategoryId}")
    public void updateDisposalGuideline (@PathVariable("id") Long id,
                                 @RequestBody @Validated DisposalGuidelineRequest disposalGuidelineRequest,
                                 @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        disposalGuidelineService.updateDisposalGuideline(id,disposalGuidelineRequest,wasteCategoryId);
    }

    // Handles DELETE requests to delete a disposal guideline by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
