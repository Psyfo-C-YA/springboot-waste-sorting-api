package com.enviro.assessment.grad001.SiyabongaHadebe.repository;

import com.enviro.assessment.grad001.SiyabongaHadebe.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    // Custom query method to check if a disposal guideline exists by ID
    boolean existsDisposalGuidelineById(Long id);
    
}
