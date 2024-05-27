package com.enviro.assessment.grad001.SiyabongaHadebe.repository;

import com.enviro.assessment.grad001.SiyabongaHadebe.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {

    // Custom query method to check if a recycling tip exists by ID
    boolean existsRecyclingTipById(Long id);

}
