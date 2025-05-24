package com.ryan.budgetcalculator.service;
import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetReportCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.mapper.BudgetReportMapper;
import com.ryan.budgetcalculator.mapper.BudgetUserMapper;
import com.ryan.budgetcalculator.repository.BudgetReportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BudgetReportService {


    private final BudgetUserService budgetUserService;
    private final BudgetReportRepository budgetReportRepository;
    private final BudgetReportMapper budgetReportMapper;


    public BudgetReportDTO createBudgetReport(BudgetReportCreateDTO budgetReportCreateDTO, UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID); // finds the Entity by given ID number
        BudgetReport budgetReport = budgetReportMapper.fromCreateDTO(budgetReportCreateDTO); // converts our given DTO into an entity
        budgetReport.setRelatedUser(budgetUser); // sets the entity's related user to the given user'
        return budgetReportMapper.toDTO(budgetReportRepository.save(budgetReport)); // saves the entity and returns the DTO
    }
}
