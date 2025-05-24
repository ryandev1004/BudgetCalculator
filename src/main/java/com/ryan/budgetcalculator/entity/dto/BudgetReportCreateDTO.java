package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;



@Data
public class BudgetReportCreateDTO {

    private String reportDetails;
    private double postMonthlyIncome;
    private double postYearlyIncome;

}
