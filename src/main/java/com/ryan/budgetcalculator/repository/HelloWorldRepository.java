package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloWorldRepository extends JpaRepository<HelloWorld, Integer> {}
