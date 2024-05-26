package com.enviro.assessment.grad001.SiyabongaHadebe.repository;


import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for WasteCategory entities.
 */
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    Optional<WasteCategory> findWasteCategoryByName(String name);
    boolean existsWasteCategoryByName(String name);
    boolean existsWasteCategoryById(Long id);

}
