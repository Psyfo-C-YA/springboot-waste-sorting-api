package com.enviro.assessment.grad001.SiyabongaHadebe.dto;

import java.util.List;

public record WasteCategoryDTO(Long id, String name, List<DisposalGuidelineDTO> disposalGuidelines, List<RecyclingTipDTO> tips) {
}
