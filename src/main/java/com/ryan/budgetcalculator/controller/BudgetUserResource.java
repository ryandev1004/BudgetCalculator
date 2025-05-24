package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.BudgetUserCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserPatchDTO;
import com.ryan.budgetcalculator.service.BudgetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BudgetUserResource {

    private final BudgetUserService budgetUserService;

    @GetMapping("users")
    public ResponseEntity<List<BudgetUserDTO>> getBudgetAllUsers() {
        return ResponseEntity.ok().body(budgetUserService.getAllBudgetUsers());
    }

    @GetMapping("users/{id}")
    public ResponseEntity<BudgetUserDTO> getBudgetUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(budgetUserService.getBudgetUserById(id));
    }

    @PostMapping("users")
    public ResponseEntity<BudgetUserDTO> addBudgetUser(@RequestBody BudgetUserCreateDTO budgetUserCreateDTO) {
        return ResponseEntity.ok().body(budgetUserService.createBudgetUser(budgetUserCreateDTO));
    }

    @PatchMapping("users/{id}")
    public ResponseEntity<BudgetUserDTO> updateBudgetUser(@RequestBody BudgetUserPatchDTO budgetUserPatchDTO, @PathVariable UUID id) {
        return ResponseEntity.ok().body(budgetUserService.updateBudgetUser(budgetUserPatchDTO, id));
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<UUID> deleteBudgetUser(@PathVariable UUID id) {
        budgetUserService.deleteBudgetUser(id);
        return ResponseEntity.ok().body(id);
    }

}
