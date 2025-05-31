package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.SavingsGoal;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalCreateDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalDTO;
import com.ryan.budgetcalculator.entity.dto.SavingsGoalPatchDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SavingsGoalMapper {

    SavingsGoalDTO toDTO(SavingsGoal savingsGoal);

    @Mapping(target = "id", ignore = true)
    SavingsGoal toEntity(SavingsGoalDTO savingsGoal);

    @Mapping(target = "id", ignore = true)
    SavingsGoal fromCreateDTO(SavingsGoalCreateDTO savingsGoalCreateDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget SavingsGoal savingsGoal, SavingsGoalPatchDTO savingsGoalPatchDTO);
}
