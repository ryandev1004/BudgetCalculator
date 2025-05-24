package com.ryan.budgetcalculator.entity.dto;

import com.ryan.budgetcalculator.entity.BudgetReport;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BudgetUserDTO {
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
    private List<BudgetReportDTO> budgetReports;
}
