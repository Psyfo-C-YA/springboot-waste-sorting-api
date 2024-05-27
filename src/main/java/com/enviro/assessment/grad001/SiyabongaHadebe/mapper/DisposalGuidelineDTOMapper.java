package com.enviro.assessment.grad001.SiyabongaHadebe.mapper;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.DisposalGuideline;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DisposalGuidelineDTOMapper implements Function<DisposalGuideline, DisposalGuidelineDTO> {

    // The apply method is overridden to define the mapping from DisposalGuideline to DisposalGuidelineDTO
    @Override
    public DisposalGuidelineDTO apply(DisposalGuideline disposalGuideline) {
        // Creating and returning a new DisposalGuidelineDTO object with values from the DisposalGuideline entity
        return new DisposalGuidelineDTO(
                disposalGuideline.getId(),
                disposalGuideline.getDescription()
        );
    }

}
