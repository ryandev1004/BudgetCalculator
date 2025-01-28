package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.BudgetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetUserRepository extends JpaRepository<BudgetUser, UUID> {
}
