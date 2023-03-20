package com.cbr.testTask.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "additional_competition")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalCompetitionEntity extends BaseEntity {
    @Column(name = "direction_of_study")
    private String directionOfStudy;
    @Column(name = "link_of_certificate")
    private String linkOfCertificate;



    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "additionalId")
    private List<CandidateToAdditionalCompetitionEntity> candidates;
}
