package com.ryan.budgetcalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Data
@Table(name = "savings_goal")
public class SavingsGoal {

    @Id
    @UuidGenerator
    private UUID id;

    private double targetAmount;

    private double savedAmount;

}
