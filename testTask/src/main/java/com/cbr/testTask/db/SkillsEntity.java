package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "skills")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillsEntity extends BaseEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "grade")
    private int grade;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "skills")
    private List<SkillToCandidateEntity> skillToCandidateEntity;
}
