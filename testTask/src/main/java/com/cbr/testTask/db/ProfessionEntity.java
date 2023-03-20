package com.cbr.testTask.db;

import com.cbr.testTask.db.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "profession")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "professionId")
    private List<ProfessionToCandidateEntity> professionToCandidateEntityList;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "profession")
    private List<SkillToProfessionEntity> skillToProfessionEntities;

}
