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
    private float yearlyIncome;
    private float monthlyRent;
    private float monthlyFoodCost;
    private float monthlyStreamingAndWifi;
    private float monthlyInsurance;
    private float monthlyOtherExpenses;

}
