package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "skill_to_profession")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillToProfessionEntity extends BaseEntity {


    @Column(name = "grade")
    private int grade;

    @ManyToOne
    private ProfessionEntity profession;

    @ManyToOne
    private SkillsEntity skill;
}
