package com.ryan.budgetcalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "budget_users")
public class BudgetUser {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private int age;

    private String occupation;

    private double yearlyIncome;

    private double monthlyRent;

    private double monthlyFoodCost;

    private double monthlyStreamingAndWifi;

    private double monthlyInsurance;

    private double monthlyOtherExpenses;

    @OneToMany(mappedBy = "budgetUser", cascade = CascadeType.ALL)
    private Set<BudgetReport> budgetReports;

}
