package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class BudgetReportDTO {

    private UUID reportId;

    private String reportDetails;

    private LocalDate reportDate;

    private double postMonthlyIncome;

    private double postYearlyIncome;

}
