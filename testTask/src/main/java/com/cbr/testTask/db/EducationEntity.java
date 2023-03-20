package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.IdentityHashMap;

@Table(name = "education")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationEntity extends BaseEntity {

    @Column(name = "grades")
    private double grades;

    @Column(name = "education_level")
    private String educationLevel;

    @ManyToOne
    private CandidatesEntity candidates;

    @ManyToOne
    private UniversitiesEntity universitiesEntity;
}
