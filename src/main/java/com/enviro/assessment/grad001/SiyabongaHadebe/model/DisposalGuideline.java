package com.enviro.assessment.grad001.SiyabongaHadebe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * Represents a disposal guideline in the system.
 */
@Entity
@Table(name = "disposal_guidelines")
// Handles circular references during JSON serialization
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Guideline description is required")
    private String description;

    // Defines a many-to-one relationship with WasteCategory
    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory;

    public DisposalGuideline(Long id, String description, WasteCategory wasteCategory) {
        this.id = id;
        this.description = description;
        this.wasteCategory = wasteCategory;
    }

    public DisposalGuideline() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }


}
