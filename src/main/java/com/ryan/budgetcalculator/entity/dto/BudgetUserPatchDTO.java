package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

@Data
public class BudgetUserPatchDTO {

    private String name;
    private Integer age;
    private String occupation;
    private Double yearlyIncome;
    private Double monthlyRent;
    private Double monthlyFoodCost;
    private Double monthlyStreamingAndWifi;
    private Double monthlyInsurance;
    private Double monthlyOtherExpenses;
}
