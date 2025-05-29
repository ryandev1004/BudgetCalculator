package com.ryan.budgetcalculator.service;

import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import com.ryan.budgetcalculator.mapper.BudgetReportMapper;
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

    public BudgetReportDTO createBudgetReport(UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        if (budgetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        BudgetReportDTO createDTO = getBudgetReportDTO(budgetUser);
        BudgetReport budgetReport = budgetReportMapper.toEntity(createDTO);
        budgetReport.setRelatedUser(budgetUser);
        return budgetReportMapper.toDTO(budgetReportRepository.save(budgetReport));
    }

    private static BudgetReportDTO getBudgetReportDTO(BudgetUser budgetUser) {
        double postMonthlyIncome =
                Math.round(((budgetUser.getYearlyIncome() / 12) - (budgetUser.getTotalMonthlyExpenses())) * 100.0)
                        / 100.0;
        double postYearlyIncome = Math.round((postMonthlyIncome * 12) * 100.0) / 100.0;
        String budgetReportDetails = getReportDetails(postMonthlyIncome);
        BudgetReportDTO createDTO = new BudgetReportDTO();
        createDTO.setPostMonthlyIncome(postMonthlyIncome);
        createDTO.setPostYearlyIncome(postYearlyIncome);
        createDTO.setReportDetails(budgetReportDetails);
        return createDTO;
    }

    private static String getReportDetails(double postMonthlyIncome) {
        String budgetReportDetails;
        if (postMonthlyIncome < 200) {
            budgetReportDetails = "You are spending too much for your yearly income: $" + postMonthlyIncome
                    + " this is your post monthly income.";
        } else if (postMonthlyIncome > 200 && postMonthlyIncome < 400) {
            budgetReportDetails = "Your current budget is sufficient but does not leave much for savings: $"
                    + postMonthlyIncome + " this is your post monthly income.";
        } else {
            budgetReportDetails = "Your current budget is excellent and leaves room for savings: $" + postMonthlyIncome
                    + " this is your post monthly income.";
        }
        return budgetReportDetails;
    }

    public List<BudgetReportDTO> getBudgetReports(UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        if (budgetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        List<BudgetReport> budgetReports = budgetReportRepository.findAllByRelatedUser(budgetUser);
        return budgetReports.stream().map(budgetReportMapper::toDTO).collect(Collectors.toList());
    }

    public BudgetReportDTO getBudgetReport(UUID reportID, UUID userID) {
        BudgetUser budgetUser = budgetUserService.findEntityByID(userID);
        if (budgetUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        Optional<BudgetReport> budgetReport = budgetReportRepository.findByReportIdAndRelatedUser(reportID, budgetUser);
        if (budgetReport.isEmpty()) {
            throw new IllegalArgumentException("Report not found");
        }
        return budgetReportMapper.toDTO(budgetReport.get());
    }
}
