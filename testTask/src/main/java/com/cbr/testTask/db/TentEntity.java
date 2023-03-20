package com.cbr.testTask.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Table(name = "test")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TentEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
}
