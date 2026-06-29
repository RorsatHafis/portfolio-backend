package com.hafis.portfolio.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 3000)
    private String description;

    private String githubUrl;

    private String liveUrl;

    private Boolean featured;

    @Builder.Default
    @ManyToMany
    @JoinTable(

            name = "project_skills",
            joinColumns =
            @JoinColumn(name = "project_id"),
            inverseJoinColumns =
            @JoinColumn(name = "skill_id")

    )
    private List<Skill> skills = new ArrayList<>();

    @Builder.Default
    @OneToMany(

            mappedBy = "project",

            cascade = CascadeType.ALL,

            orphanRemoval = true

    )
    private List<Image> images = new ArrayList<>();

    
}
