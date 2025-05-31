package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

@Data
public class SavingsGoalPatchDTO {
    private double targetAmount;
    private double savedAmount;
}
