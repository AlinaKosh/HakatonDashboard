package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "chosen_candidate")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChosenCandidateEntity extends BaseEntity {
    @Column(name = "candidate_id")
    private int candidateId;
    @Column(name = "user_id")
    private int userId;
}
