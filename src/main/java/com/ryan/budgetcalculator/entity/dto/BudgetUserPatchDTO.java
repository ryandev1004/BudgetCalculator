package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

@Data
public class BudgetUserPatchDTO {

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
