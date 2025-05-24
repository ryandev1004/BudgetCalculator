package com.ryan.budgetcalculator.service;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.SavingsGoal;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalCreateDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalDTO;
import com.ryan.budgetcalculator.mapper.SavingsGoalMapper;
import com.ryan.budgetcalculator.repository.SavingsGoalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SavingsGoalService {

    private final BudgetUserService budgetUserService;
    private final SavingsGoalMapper savingsGoalMapper;
    private final SavingsGoalRepository savingsGoalRepository;

    public SavingsGoalDTO createSavingsGoal(SavingsGoalCreateDTO savingsGoalCreateDTO, UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        SavingsGoal savingsGoal = savingsGoalMapper.fromCreateDTO(savingsGoalCreateDTO);
        savingsGoal.setBudgetUser(budgetUser);
        return savingsGoalMapper.toDTO(savingsGoalRepository.save(savingsGoal));
    }
}
