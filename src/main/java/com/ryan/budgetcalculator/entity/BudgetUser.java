package com.ryan.budgetcalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "budget_users")
public class BudgetUser {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    private String occupation;

    @Column(nullable = false)
    private double yearlyIncome;

    private double monthlyRent;

    private double monthlyFoodCost;

    private double monthlyStreamingAndWifi;

    private double monthlyInsurance;

    private double monthlyOtherExpenses;

    @OneToMany(mappedBy = "relatedUser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BudgetReport> budgetReports;

    @OneToOne(mappedBy = "budgetUser", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn
    private SavingsGoal savingsGoal;

}
