package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "skill_to_candidate")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillToCandidateEntity extends BaseEntity {


    @ManyToOne
    private CandidatesEntity candidates;

    @ManyToOne
    private SkillsEntity skills;


}