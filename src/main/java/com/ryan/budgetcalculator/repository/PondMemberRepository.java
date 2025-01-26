package com.ryan.budgetcalculator.repository;

import com.ryan.budgetcalculator.entity.PondMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PondMemberRepository extends JpaRepository<PondMember, UUID> {}
