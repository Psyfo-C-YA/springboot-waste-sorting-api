package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.RecyclingTipRequest;

import java.util.List;

// Interface defining the contract for recycling tip services
public interface RecyclingTipService {

    // Method to get all recycling tips
    List<RecyclingTipDTO> findAllRecyclingTips();

    // Method to get a recycling tip by ID
    RecyclingTipDTO findRecyclingTipById(Long id);

    // Method to create a new recycling tip
    void createRecyclingTip(RecyclingTipRequest recyclingTipRequest, Long categoryId);

    // Method to update a recycling tip
    void updateRecyclingTip(Long id, RecyclingTipRequest recyclingTipRequest, Long categoryId);

    // Method to delete a recycling tip by ID
    void deleteRecyclingTip(Long id);

}
