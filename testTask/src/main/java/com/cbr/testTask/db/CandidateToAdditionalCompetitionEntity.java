package com.cbr.testTask.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "candidate_to_additional_competition")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateToAdditionalCompetitionEntity extends BaseEntity {


    @ManyToOne
    private CandidatesEntity candidateId;


    @ManyToOne
    private AdditionalCompetitionEntity additionalId;




 /*   @ManyToOne
    @JoinColumn(name = "candidates_entity_id")
    private CandidatesEntity candidateId; */

}
