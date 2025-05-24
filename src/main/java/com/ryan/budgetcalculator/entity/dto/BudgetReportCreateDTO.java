package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class BudgetReportCreateDTO {

    private String reportDetails;
    private LocalDate reportDate = LocalDate.now();
    private double postMonthlyIncome;
    private double postYearlyIncome;

}
