package com.cbr.testTask.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "candidates")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatesEntity extends BaseEntity {
    @Column(name = "name")
    private String name;



    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "candidateId")
    private List<CandidateToAdditionalCompetitionEntity> additionalCompetitionId;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "candidateId")
    private List<ProfessionToCandidateEntity> professionToCandidateEntityList;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "candidates")
    private List<EducationEntity> educationEntities;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "candidates")
    private List<SkillToCandidateEntity> skillToCandidateEntities;
   /* @Column(name = "achievement_id")
    @OneToMany(mappedBy = "additionalId")
    private List<CandidateToAdditionalCompetitionEntity> achievementId; */
}
