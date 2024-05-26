package com.enviro.assessment.grad001.SiyabongaHadebe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * Represents a category of waste in the system.
 */
@Entity
@Table(name = "categories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Category name is required")
    private String name;


//    @JsonIgnore
//    @OneToMany(mappedBy = "wasteCategory", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "wasteCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisposalGuideline> disposalGuidelines;

//    @JsonIgnore
//    @OneToMany(mappedBy = "wasteCategory", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "wasteCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecyclingTip> recyclingTips;

    public WasteCategory(Long id, String name, List<DisposalGuideline> disposalGuidelines, List<RecyclingTip> recyclingTips) {
        this.id = id;
        this.name = name;
        this.disposalGuidelines = disposalGuidelines;
        this.recyclingTips = recyclingTips;
    }

    public WasteCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DisposalGuideline> getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(List<DisposalGuideline> disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}
