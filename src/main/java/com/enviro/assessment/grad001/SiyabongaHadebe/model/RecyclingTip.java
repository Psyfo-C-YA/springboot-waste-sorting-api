package com.enviro.assessment.grad001.SiyabongaHadebe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * Represents a recycling tip in the system.
 */
@Entity
@Table(name = "recycling_tips")
// Handles circular references during JSON serialization
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tip description is required")
    private String tip;

    // Defines a many-to-one relationship with WasteCategory
    @ManyToOne
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory;

    public RecyclingTip(Long id, String tip, WasteCategory wasteCategory) {
        this.id = id;
        this.tip = tip;
        this.wasteCategory = wasteCategory;
    }

    public RecyclingTip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
