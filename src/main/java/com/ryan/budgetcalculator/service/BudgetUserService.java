package com.ryan.budgetcalculator.service;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetUserCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.mapper.BudgetUserMapper;
import com.ryan.budgetcalculator.repository.BudgetUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BudgetUserService {

    private final BudgetUserRepository budgetUserRepository;
    private final BudgetUserMapper budgetUserMapper;

    public List<BudgetUserDTO> getAllBudgetUsers() {
        List<BudgetUser> allUsers = budgetUserRepository.findAll();
        return allUsers.stream().map(budgetUserMapper::toDTO).collect(Collectors.toList());
    }

    public BudgetUserDTO createBudgetUser(BudgetUserCreateDTO budgetUserCreateDTO) {
        BudgetUser budgetUser = budgetUserMapper.fromCreateDTO(budgetUserCreateDTO);
        BudgetUser savedBudgetUser = budgetUserRepository.save(budgetUser);
        return budgetUserMapper.toDTO(savedBudgetUser);
    }

    public void deleteBudgetUser(UUID budgetUserId) { budgetUserRepository.deleteById(budgetUserId); }
}
