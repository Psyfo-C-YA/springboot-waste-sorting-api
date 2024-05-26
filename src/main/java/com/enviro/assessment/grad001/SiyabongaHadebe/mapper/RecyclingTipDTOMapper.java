package com.enviro.assessment.grad001.SiyabongaHadebe.mapper;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.model.RecyclingTip;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RecyclingTipDTOMapper implements Function<RecyclingTip, RecyclingTipDTO> {

    @Override
    public RecyclingTipDTO apply(RecyclingTip recyclingTip) {
        return new RecyclingTipDTO(
                recyclingTip.getId(),
                recyclingTip.getTip()
        );
    }

}