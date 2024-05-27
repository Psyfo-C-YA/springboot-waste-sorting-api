package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.DisposalGuidelineRequest;

import java.util.List;

// Interface defining the methods for disposal guideline services
public interface DisposalGuidelineService {

    // Method to get all disposal guidelines
    List<DisposalGuidelineDTO> findAllDisposalGuidelines();

    // Method to get a disposal guideline by ID
    DisposalGuidelineDTO findDisposalGuidelineById(Long id);

     // Method to delete a disposal guideline by ID
    void deleteDisposalGuideline(Long id);

    // Method to create a new disposal guideline
    void createDisposalGuideline(DisposalGuidelineRequest guideLineRequest, Long categoryId);

    // Method to update a disposal guideline
    void updateDisposalGuideline(Long id, DisposalGuidelineRequest guideLineRequest, Long categoryId);

}
