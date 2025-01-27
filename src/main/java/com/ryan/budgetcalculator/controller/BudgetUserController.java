package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.repository.BudgetUserRepository;
import com.ryan.budgetcalculator.service.BudgetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BudgetUserController {

    private final BudgetUserService budgetUserService;

    @GetMapping("users")
    public ResponseEntity<List<BudgetUserDTO>> getBudgetAllUsers() {
        return ResponseEntity.ok().body(budgetUserService.getAllBudgetUsers());
    }


}
