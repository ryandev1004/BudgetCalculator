package com.ryan.budgetcalculator.examples.repository;

import com.ryan.budgetcalculator.examples.entity.PondMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PondMemberRepository extends JpaRepository<PondMember, UUID> {

    @Query(value = "SELECT pm FROM PondMember pm WHERE pm.rank = :rank")
    List<PondMember> findPondMemberByRank(char rank);
    
}
