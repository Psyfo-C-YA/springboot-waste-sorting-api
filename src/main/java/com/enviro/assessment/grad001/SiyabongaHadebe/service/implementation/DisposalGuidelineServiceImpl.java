package com.enviro.assessment.grad001.SiyabongaHadebe.service.implementation;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.RequestValidationException;
import com.enviro.assessment.grad001.SiyabongaHadebe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.SiyabongaHadebe.mapper.DisposalGuidelineDTOMapper;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.DisposalGuideline;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import com.enviro.assessment.grad001.SiyabongaHadebe.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.SiyabongaHadebe.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.SiyabongaHadebe.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing disposal guidelines.
 */
@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private DisposalGuidelineDTOMapper disposalGuidelineDTOMapper;

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    /**
     * Retrieves all disposal guidelines.
     * @return a list of disposal guidelines.
     */
    @Override
    public List<DisposalGuidelineDTO> findAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll()
                .stream()
                .map(disposalGuidelineDTOMapper)
                .collect(Collectors.toList());
    }



    /**
     * Retrieves a disposal guideline by its ID.
     * @param id the ID of the disposal guideline.
     * @return an Optional containing the disposal guideline if found, or empty if not.
     */
    public DisposalGuidelineDTO findDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .map(disposalGuidelineDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "disposal guideline with id [%s] not found".formatted(id)
                ));
    }

    /**
     * Saves a new disposal guideline.
     * @param disposalGuidelineRequest the disposal guideline to save.
     * @return the saved disposal guideline.
     */
    @Override
    public void createDisposalGuideline(DisposalGuidelineRequest disposalGuidelineRequest, Long wasteCategoryId) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("waste category with id [%s] not found".formatted(wasteCategoryId)
                ));

        DisposalGuideline disposalGuideline = new DisposalGuideline();
        disposalGuideline.setWasteCategory(wasteCategory);
        disposalGuideline.setDescription(disposalGuidelineRequest.description());
        disposalGuidelineRepository.save(disposalGuideline);
    }



    /**
     * Deletes a disposal guideline by its ID.
     * @param id the ID of the disposal guideline to delete.
     */
     public void deleteDisposalGuideline(Long id) {
         checkIfDisposalGuidelineExistsOrThrow(id);
         disposalGuidelineRepository.deleteById(id);
     }

    private void checkIfDisposalGuidelineExistsOrThrow(Long id) {
        if (!disposalGuidelineRepository.existsDisposalGuidelineById(id)) {
            throw new ResourceNotFoundException(
                    "disposal guideline with id [%s] not found".formatted(id)
            );
        }
    }


    @Override
    public void updateDisposalGuideline(Long id, DisposalGuidelineRequest guideLineRequest, Long wasteCategoryId) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("waste category with id [%s] not found".formatted(wasteCategoryId)
                ));

        DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disposal guideline with id [%s] not found".formatted(id)
                ));

        boolean changes = false;

        if (guideLineRequest.description() != null && !guideLineRequest.description().equals(disposalGuideline.getDescription())) {
            disposalGuideline.setDescription(guideLineRequest.description());
            changes = true;
        }

        if (wasteCategory != null) {
            disposalGuideline.setWasteCategory(wasteCategory);
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes");
        }

        disposalGuidelineRepository.save(disposalGuideline);
    }


}
