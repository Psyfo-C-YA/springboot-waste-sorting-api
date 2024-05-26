package com.enviro.assessment.grad001.SiyabongaHadebe.controller;


import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
//import com.enviro.assessment.grad001.SiyabongaHadebe.requests.DisposalGuidelineRequest;
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

    @Autowired
    private DisposalGuidelineService  disposalGuidelineService;

//    private DisposalGuidelineRequest disposalGuidelineRequest;

    /**
     * Retrieves all disposal guidelines.
     * @return a list of disposal guidelines.
     */
    @GetMapping
    public List<DisposalGuidelineDTO> getAllDisposalGuidelines() {
        return disposalGuidelineService.findAllDisposalGuidelines();
    }

    /**
     * Retrieves a disposal guideline by its ID.
     * @param id the ID of the disposal guideline.
     * @return the disposal guideline, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getDisposalGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(disposalGuidelineService.findDisposalGuidelineById(id));
    }

    /**
     * Creates a new disposal guideline.
     * @param disposalGuidelineRequest the disposal guideline to create.
     * @return the created disposal guideline.
     */
    @PostMapping("/{wasteCategoryId}")
    public void createDisposalGuideline(@RequestBody @Validated DisposalGuidelineRequest disposalGuidelineRequest, @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        disposalGuidelineService.createDisposalGuideline(disposalGuidelineRequest, wasteCategoryId);
    }

//
//    @PutMapping("/{wasteCategoryId}")
//    public ResponseEntity<Void> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelineRequest disposalGuidelineRequest, @RequestParam Long wasteCategoryId) {
//        disposalGuidelineService.updateDisposalGuideline(id, disposalGuidelineRequest, wasteCategoryId);
//        return ResponseEntity.ok().build();
//    }

    @PutMapping("{id}/guideline/{wasteCategoryId}")
    public void updateDisposalGuideline (@PathVariable("id") Long id,
                                 @RequestBody @Validated DisposalGuidelineRequest disposalGuidelineRequest,
                                 @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        disposalGuidelineService.updateDisposalGuideline(id,disposalGuidelineRequest,wasteCategoryId);
    }


    /**
     * Deletes a disposal guideline by its ID.
     * @param id the ID of the disposal guideline to delete.
     * @return 204 No Content if successful, 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }


}
