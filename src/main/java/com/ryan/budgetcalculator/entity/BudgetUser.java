package com.ryan.budgetcalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

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

}
