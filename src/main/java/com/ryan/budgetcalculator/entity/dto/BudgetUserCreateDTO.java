package com.ryan.budgetcalculator.entity.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BudgetUserCreateDTO {

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @Nullable
    private String occupation;

    @NotNull
    private double yearlyIncome;

    @Nullable
    private Double monthlyRent;

    @Nullable
    private Double monthlyFoodCost;

    @Nullable
    private Double monthlyStreamingAndWifi;

    @Nullable
    private Double monthlyInsurance;

    @Nullable
    private Double monthlyOtherExpenses;

}
