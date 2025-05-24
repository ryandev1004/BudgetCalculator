package com.ryan.budgetcalculator.service;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetUserCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserPatchDTO;
import com.ryan.budgetcalculator.mapper.BudgetUserMapper;
import com.ryan.budgetcalculator.repository.BudgetUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BudgetUserService {

    private final BudgetUserRepository budgetUserRepository;
    private final BudgetUserMapper budgetUserMapper;

    public List<BudgetUserDTO> getAllBudgetUsers() {
        List<BudgetUser> allUsers = budgetUserRepository.findAll();
        return allUsers.stream()
                .map(budgetUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BudgetUserDTO getBudgetUserById(UUID id) {
        return budgetUserMapper.toDTO(budgetUserRepository.findById(id).orElse(null));
    }

    public BudgetUserDTO createBudgetUser(BudgetUserCreateDTO budgetUserCreateDTO) {
        BudgetUser budgetUser = budgetUserMapper.fromCreateDTO(budgetUserCreateDTO);
        return budgetUserMapper.toDTO(budgetUserRepository.save(budgetUser));
    }

    public BudgetUserDTO updateBudgetUser(BudgetUserPatchDTO budgetUserPatchDTO, UUID id) {
        BudgetUser budgetUser = budgetUserRepository.findById(id).orElse(null);
        assert budgetUser != null;
        budgetUserMapper.partialUpdate(budgetUser, budgetUserPatchDTO);
        return budgetUserMapper.toDTO(budgetUserRepository.save(budgetUser));
    }

    public BudgetUser findEntityByID(UUID id) {
        return budgetUserRepository.findById(id).orElse(null);
    }

    public void deleteBudgetUser(UUID budgetUserId) { budgetUserRepository.deleteById(budgetUserId); }
}
