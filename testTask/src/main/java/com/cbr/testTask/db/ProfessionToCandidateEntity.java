package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "profession_to_candidate")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionToCandidateEntity extends BaseEntity {

    @ManyToOne
    private CandidatesEntity candidateId;


    @ManyToOne
    private ProfessionEntity professionId;
}
