package com.ryan.budgetcalculator.entity;

import jakarta.persistence.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_user_id", nullable = false)
    private BudgetUser budgetUser;
}
