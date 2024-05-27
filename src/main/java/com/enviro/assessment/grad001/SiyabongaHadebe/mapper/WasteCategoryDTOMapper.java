package com.enviro.assessment.grad001.SiyabongaHadebe.mapper;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WasteCategoryDTOMapper implements Function<WasteCategory, WasteCategoryDTO> {

    // Injects disposal guideline data transfer object mapper dependency
    @Autowired
    private DisposalGuidelineDTOMapper disposalGuidelineDTOMapper;

    
    // Injects recycling tip data transfer object mapper dependency
    @Autowired
    private RecyclingTipDTOMapper recyclingTipDTOMapper;

    @Override
    public WasteCategoryDTO apply(WasteCategory wasteCategory) {
        // Convert the list of DisposalGuidelines to DisposalGuidelineDTOs
        List<DisposalGuidelineDTO> guidelines = wasteCategory.getDisposalGuidelines()
                .stream()
                .map(disposalGuidelineDTOMapper)
                .collect(Collectors.toList());

        // Convert the list of RecyclingTips to RecyclingTipDTOs
        List<RecyclingTipDTO> tips = wasteCategory.getRecyclingTips()
                .stream()
                .map(recyclingTipDTOMapper)
                .collect(Collectors.toList());

        // Return a new WasteCategoryDTO with the mapped fields
        return new WasteCategoryDTO(
                wasteCategory.getId(),
                wasteCategory.getName(),
                guidelines,
                tips
        );
    }

}
