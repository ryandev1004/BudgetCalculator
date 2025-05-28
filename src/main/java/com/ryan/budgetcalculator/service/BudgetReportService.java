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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<BudgetReportDTO> getBudgetReports(UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        if(budgetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        List<BudgetReport> budgetReports = budgetReportRepository.findAllByRelatedUser(budgetUser);
        return budgetReports.stream().map(budgetReportMapper::toDTO).collect(Collectors.toList());
    }

    public BudgetReportDTO getBudgetReport(UUID reportID, UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        if(budgetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        Optional<BudgetReport> budgetReport = budgetReportRepository.findByReportIdAndRelatedUser(reportID, budgetUser);
        if(budgetReport.isEmpty()) {
            throw new IllegalArgumentException("Report not found");
        }
        return budgetReportMapper.toDTO(budgetReport.get());
    }
}
