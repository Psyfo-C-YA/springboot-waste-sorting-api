package com.enviro.assessment.grad001.SiyabongaHadebe.repository;

import com.enviro.assessment.grad001.SiyabongaHadebe.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {

    boolean existsRecyclingTipById(Long id);

}
