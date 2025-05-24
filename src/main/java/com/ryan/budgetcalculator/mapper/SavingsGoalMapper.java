package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.SavingsGoal;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalCreateDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SavingsGoalMapper {

    SavingsGoalDTO toDTO(SavingsGoal savingsGoal);

    @Mapping(target = "id", ignore = true)
    SavingsGoal toEntity(SavingsGoalDTO savingsGoal);

    @Mapping(target = "id", ignore = true)
    SavingsGoal fromCreateDTO(SavingsGoalCreateDTO savingsGoalCreateDTO);

}
