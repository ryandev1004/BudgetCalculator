package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import com.ryan.budgetcalculator.service.BudgetReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BudgetReportResource {

    private final BudgetReportService budgetReportService;

    @PostMapping("reports/{userID}")
    public ResponseEntity<BudgetReportDTO> createBudgetReport(@PathVariable UUID userID) {
        return ResponseEntity.ok().body(budgetReportService.createBudgetReport(userID));
    }

    @GetMapping("reports/{userID}")
    public ResponseEntity<List<BudgetReportDTO>> getBudgetReports(@PathVariable UUID userID) {
        return ResponseEntity.ok().body(budgetReportService.getBudgetReports(userID));
    }

    @GetMapping("reports/{userID}/report/{reportID}")
    public ResponseEntity<BudgetReportDTO> getBudgetReport(@PathVariable UUID userID, @PathVariable UUID reportID) {
        return ResponseEntity.ok().body(budgetReportService.getBudgetReport(reportID, userID));
    }
}
