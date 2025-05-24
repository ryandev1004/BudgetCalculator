package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

@Data
public class SavingsGoalCreateDTO {
    private double targetAmount;
    private double savedAmount;
}
