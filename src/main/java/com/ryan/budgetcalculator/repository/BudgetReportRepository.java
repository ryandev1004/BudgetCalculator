package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.BudgetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BudgetReportRepository extends JpaRepository<BudgetReport, UUID> {

    List<BudgetReport> findAllByRelatedUser(BudgetUser budgetUser);

    Optional<BudgetReport> findByReportIdAndRelatedUser(UUID reportId, BudgetUser budgetUser);

}
