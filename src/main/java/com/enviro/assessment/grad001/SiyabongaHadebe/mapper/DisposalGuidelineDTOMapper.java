package com.enviro.assessment.grad001.SiyabongaHadebe.mapper;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.DisposalGuideline;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DisposalGuidelineDTOMapper implements Function<DisposalGuideline, DisposalGuidelineDTO> {

    @Override
    public DisposalGuidelineDTO apply(DisposalGuideline disposalGuideline) {
        return new DisposalGuidelineDTO(
                disposalGuideline.getId(),
                disposalGuideline.getDescription()
        );
    }

}