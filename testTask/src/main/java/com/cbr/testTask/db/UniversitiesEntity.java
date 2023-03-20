package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "universities")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversitiesEntity extends BaseEntity {


    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "universitiesEntity")
    private List<EducationEntity> educationEntities;
}
