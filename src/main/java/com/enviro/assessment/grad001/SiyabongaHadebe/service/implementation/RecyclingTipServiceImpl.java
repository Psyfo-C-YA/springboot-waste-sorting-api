package com.enviro.assessment.grad001.SiyabongaHadebe.service.implementation;


import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.RequestValidationException;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.SiyabongaHadebe.mapper.RecyclingTipDTOMapper;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.RecyclingTip;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import com.enviro.assessment.grad001.SiyabongaHadebe.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.SiyabongaHadebe.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.RecyclingTipRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing recycling tips.
 */
@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    // Injects the RecyclingTipRepository dependency
    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    // Injects the RecyclingTipDTOMapper dependency
    @Autowired
    private RecyclingTipDTOMapper recyclingTipDTOMapper;

    // Injects the WasteCategoryRepository dependency
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // Retrieves all recycling tips and maps them to DTOs
    public List<RecyclingTipDTO> findAllRecyclingTips() {
        return recyclingTipRepository.findAll().stream()
                .map(recyclingTipDTOMapper)
                .collect(Collectors.toList());
    }

    // Retrieves a recycling tip by ID and maps it to a DTO
    public RecyclingTipDTO findRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .map(recyclingTipDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "recycling tip with id [%s] not found".formatted(id)
                ));
    }

    // Creates a new recycling tip
    @Override
    public void createRecyclingTip(RecyclingTipRequest recyclingTipRequest, Long wasteCategoryId) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("waste category with id [%s] not found".formatted(wasteCategoryId)
                ));
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setWasteCategory(wasteCategory);
        recyclingTip.setTip(recyclingTipRequest.tip());

        recyclingTipRepository.save(recyclingTip);
    }

    // Updates a recycling tip
    @Override
    public void updateRecyclingTip(Long id, RecyclingTipRequest recyclingTipRequest, Long wasteCategoryId) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("waste category with id [%s] not found".formatted(wasteCategoryId)
                ));

        RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "recycling tip with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if (recyclingTipRequest.tip() != null && !recyclingTipRequest.tip().equals(recyclingTip.getTip())) {
            recyclingTip.setTip(recyclingTipRequest.tip());
            changes = true;
        }

        if (wasteCategory != null) {
            recyclingTip.setWasteCategory(wasteCategory);
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes");
        }

        recyclingTipRepository.save(recyclingTip);
    }

    // Deletes a recycling tip by ID
    public void deleteRecyclingTip(Long id) {
        checkIfRecyclingTipExistsOrThrow(id);
        recyclingTipRepository.deleteById(id);
    }

    // Helper method that checks if a recycling tip exists by ID, throws an exception if not
    private void checkIfRecyclingTipExistsOrThrow(Long id) {
        if (!recyclingTipRepository.existsRecyclingTipById(id)) {
            throw new ResourceNotFoundException(
                    "recycling tip with id [%s] not found".formatted(id)
            );
        }
    }
}
