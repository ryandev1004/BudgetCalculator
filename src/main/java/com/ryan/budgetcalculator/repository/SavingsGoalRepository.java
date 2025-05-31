package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.SavingsGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, UUID> {

    Optional<SavingsGoal> findByBudgetUser(BudgetUser budgetUser);

    void deleteByBudgetUser(BudgetUser budgetUser);
}
