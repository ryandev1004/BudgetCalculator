package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SavingsGoalDTO {

    private UUID id;
    private double targetAmount;
    private double savedAmount;

}
