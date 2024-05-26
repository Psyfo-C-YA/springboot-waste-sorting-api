package com.enviro.assessment.grad001.SiyabongaHadebe.repository;

import com.enviro.assessment.grad001.SiyabongaHadebe.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    boolean existsDisposalGuidelineById(Long id);
}
