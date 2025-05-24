package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.SavingsGoalCreateDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalDTO;
import com.ryan.budgetcalculator.service.SavingsGoalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SavingsGoalResource {

    private final SavingsGoalService savingsGoalService;

    @PostMapping("goals/{userID}")
    public ResponseEntity<SavingsGoalDTO> createSavingsGoal(@RequestBody SavingsGoalCreateDTO savingsGoalCreateDTO, @PathVariable UUID userID) {
        log.info("Creating a new savings goal for user: {}", userID);
        return ResponseEntity.ok().body(savingsGoalService.createSavingsGoal(savingsGoalCreateDTO, userID));
    }
}
