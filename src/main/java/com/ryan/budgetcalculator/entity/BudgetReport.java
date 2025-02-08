package com.ryan.budgetcalculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class BudgetReport {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String reportDetails;

    private LocalDate reportDate;

    private double postMonthlyIncome;

    private double postYearlyIncome;

    @ManyToOne
    @JoinColumn(name = "budget_user_id")
    private BudgetUser budgetUser;

}
