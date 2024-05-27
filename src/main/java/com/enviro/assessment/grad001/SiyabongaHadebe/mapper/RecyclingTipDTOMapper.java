package com.enviro.assessment.grad001.SiyabongaHadebe.mapper;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.RecyclingTip;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Service class to map RecyclingTip entities to RecyclingTipDTOs.
 * This class is annotated as a Spring service, indicating that it is a candidate
 * for Spring's dependency injection mechanism and can be autowired into other components.
 */
@Service
public class RecyclingTipDTOMapper implements Function<RecyclingTip, RecyclingTipDTO> {

    @Override
    public RecyclingTipDTO apply(RecyclingTip recyclingTip) {
        // Creating and returning a new RecyclingTipDTO object with values from the RecyclingTip entity
        return new RecyclingTipDTO(
                recyclingTip.getId(),
                recyclingTip.getTip()
        );
    }

}
