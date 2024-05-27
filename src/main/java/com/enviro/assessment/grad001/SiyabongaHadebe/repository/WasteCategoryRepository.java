package com.enviro.assessment.grad001.SiyabongaHadebe.repository;


import com.enviro.assessment.grad001.SiyabongaHadebe.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for WasteCategory entities.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    // Custom query method to find a category by name
    Optional<WasteCategory> findWasteCategoryByName(String name);

     // Custom query method to check if a category exists by name
    boolean existsWasteCategoryByName(String name);

    // Custom query method to check if a category exists by ID
    boolean existsWasteCategoryById(Long id);

}
