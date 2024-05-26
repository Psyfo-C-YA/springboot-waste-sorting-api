package com.enviro.assessment.grad001.SiyabongaHadebe.service;

import com.enviro.assessment.grad001.SiyabongaHadebe.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.SiyabongaHadebe.requests.DisposalGuidelineRequest;

import java.util.List;

public interface DisposalGuidelineService {

    List<DisposalGuidelineDTO> findAllDisposalGuidelines();
    DisposalGuidelineDTO findDisposalGuidelineById(Long id);
    void deleteDisposalGuideline(Long id);
    void createDisposalGuideline(DisposalGuidelineRequest guideLineRequest, Long categoryId);
    void updateDisposalGuideline(Long id, DisposalGuidelineRequest guideLineRequest, Long categoryId);

}
