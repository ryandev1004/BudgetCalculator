package com.ryan.budgetcalculator.examples.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "pond_members")
public class PondMember {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private int age;
    private char rank;

}
