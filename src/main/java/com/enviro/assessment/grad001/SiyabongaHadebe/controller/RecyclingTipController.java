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

    @Autowired
    private RecyclingTipService recyclingTipService;

    /**
     * Retrieves all recycling tips.
     * @return a list of recycling tips.
     */
    @GetMapping
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        return recyclingTipService.findAllRecyclingTips();
    }

    /**
     * Retrieves a recycling tip by its ID.
     * @param id the ID of the recycling tip.
     * @return the recycling tip, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTipDTO> getRecyclingTipById(@PathVariable Long id) {
        return ResponseEntity.ok(recyclingTipService.findRecyclingTipById(id));
    }

    /**
     * Creates a new recycling tip.
     * @param recyclingTipRequest the recycling tip to create.
     * @param wasteCategoryId the recycling tip to create.
     * @return the created recycling tip.
     */
    @PostMapping("{wasteCategoryId}")
    public void createRecyclingTip(
            @RequestBody @Validated RecyclingTipRequest recyclingTipRequest ,
            @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        recyclingTipService.createRecyclingTip(recyclingTipRequest, wasteCategoryId);
    }

    @PutMapping("{id}/tip/{wasteCategoryId}")
    public void updateRecyclingTip(@PathVariable("id") Long id,
                                                    @RequestBody @Validated RecyclingTipRequest recyclingTipRequest,
                                                    @PathVariable("wasteCategoryId") Long wasteCategoryId) {
        recyclingTipService.updateRecyclingTip(id,recyclingTipRequest,wasteCategoryId);
    }

    /**
     * Deletes a recycling tip by its ID.
     * @param id the ID of the recycling tip to delete.
     * @return 204 No Content if successful, 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }

}
