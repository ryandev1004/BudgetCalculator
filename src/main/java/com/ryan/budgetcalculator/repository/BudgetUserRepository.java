package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.BudgetUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BudgetUserRepository extends JpaRepository<BudgetUser, UUID> {

    @EntityGraph(attributePaths = {"budgetReports"})
    @Override
    List<BudgetUser> findAll();

    @EntityGraph(attributePaths = {"budgetReports"})
    @Override
    Optional<BudgetUser> findById(UUID id);

}
