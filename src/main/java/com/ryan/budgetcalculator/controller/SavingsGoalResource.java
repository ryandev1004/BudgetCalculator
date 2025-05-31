package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.SavingsGoalCreateDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalPatchDTO;
import com.ryan.budgetcalculator.service.SavingsGoalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SavingsGoalResource {

    private final SavingsGoalService savingsGoalService;

    @PostMapping("goals/{userID}")
    public ResponseEntity<SavingsGoalDTO> createSavingsGoal(
            @RequestBody SavingsGoalCreateDTO savingsGoalCreateDTO, @PathVariable UUID userID) {
        log.info("Creating a new savings goal for user: {}", userID);
        return ResponseEntity.ok().body(savingsGoalService.createSavingsGoal(savingsGoalCreateDTO, userID));
    }

    @PatchMapping("goals/{userID}")
    public ResponseEntity<SavingsGoalDTO> updateSavingsGoal(
            @RequestBody SavingsGoalPatchDTO savingsGoalPatchDTO, @PathVariable UUID userID) {
        log.info("Updating a savings goal for user: {}", userID);
        return ResponseEntity.ok().body(savingsGoalService.updateSavingsGoal(savingsGoalPatchDTO, userID));
    }

    @GetMapping("goals/{userID}")
    public ResponseEntity<SavingsGoalDTO> getSavingsGoal(@PathVariable UUID userID) {
        log.info("Retrieving a savings goal for user: {}", userID);
        return ResponseEntity.ok().body(savingsGoalService.getSavingsGoal(userID));
    }

    @DeleteMapping("goals/{userID}")
    public ResponseEntity<UUID> deleteSavingsGoal(@PathVariable UUID userID) {
        log.info("Deleting a savings goal for user: {}", userID);
        savingsGoalService.deleteSavingsGoal(userID);
        return ResponseEntity.ok().body(userID);
    }
}
