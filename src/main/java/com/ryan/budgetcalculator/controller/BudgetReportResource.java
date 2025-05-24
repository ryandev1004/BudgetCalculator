package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.BudgetReportCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import com.ryan.budgetcalculator.service.BudgetReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor // Without this we wouldn't be able to initialize the service object
public class BudgetReportResource {

    private final BudgetReportService budgetReportService;

    @PostMapping("reports/{userID}")
    public ResponseEntity<BudgetReportDTO> createBudgetReport(@RequestBody BudgetReportCreateDTO budgetReportCreateDTO, @PathVariable UUID userID) {
        return ResponseEntity.ok().body(budgetReportService.createBudgetReport(budgetReportCreateDTO, userID));
    }
}
