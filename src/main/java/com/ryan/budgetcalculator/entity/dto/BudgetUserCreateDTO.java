package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

@Data
public class BudgetUserCreateDTO {

    private String name;
    private Integer age;
    private String occupation;
    private double yearlyIncome;
    private double monthlyRent;
    private double monthlyFoodCost;
    private double monthlyStreamingAndWifi;
    private double monthlyInsurance;
    private double monthlyOtherExpenses;

}
