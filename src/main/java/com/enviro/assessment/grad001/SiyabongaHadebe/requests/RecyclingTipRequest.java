package com.enviro.assessment.grad001.SiyabongaHadebe.requests;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

// Request class for creating or updating a recycling tip
public record RecyclingTipRequest(@NonNull @NotBlank String tip) {
}
