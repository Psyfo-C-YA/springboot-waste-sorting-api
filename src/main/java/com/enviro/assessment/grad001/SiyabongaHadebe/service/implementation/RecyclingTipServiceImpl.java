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

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @Autowired
    private RecyclingTipDTOMapper recyclingTipDTOMapper;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    /**
     * Retrieves all recycling tips.
     * @return a list of recycling tips.
     */
    public List<RecyclingTipDTO> findAllRecyclingTips() {
        return recyclingTipRepository.findAll().stream()
                .map(recyclingTipDTOMapper)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a recycling tip by its ID.
     *
     * @param id the ID of the recycling tip.
     * @return an Optional containing the recycling tip if found,
     * * @return an Optional containing the recycling tip if found, or empty if not.
     */
    public RecyclingTipDTO findRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .map(recyclingTipDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "recycling tip with id [%s] not found".formatted(id)
                ));
    }

    /**
     * Saves a new recycling tip.
     * @param recyclingTipRequest the recycling tip to save.
     * @return the saved recycling tip.
     */
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

    /**
     * Deletes a recycling tip by its ID.
     * @param id the ID of the recycling tip to delete.
     */
    public void deleteRecyclingTip(Long id) {
        checkIfRecyclingTipExistsOrThrow(id);
        recyclingTipRepository.deleteById(id);
    }

    private void checkIfRecyclingTipExistsOrThrow(Long id) {
        if (!recyclingTipRepository.existsRecyclingTipById(id)) {
            throw new ResourceNotFoundException(
                    "recycling tip with id [%s] not found".formatted(id)
            );
        }
    }
}
