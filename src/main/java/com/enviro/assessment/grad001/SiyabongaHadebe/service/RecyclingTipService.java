package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.RecyclingTipRequest;

import java.util.List;

public interface RecyclingTipService {

    List<RecyclingTipDTO> findAllRecyclingTips();
    RecyclingTipDTO findRecyclingTipById(Long id);
    void createRecyclingTip(RecyclingTipRequest recyclingTipRequest, Long categoryId);
    void updateRecyclingTip(Long id, RecyclingTipRequest recyclingTipRequest, Long categoryId);
    void deleteRecyclingTip(Long id);

}
