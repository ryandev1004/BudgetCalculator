package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetUserMapper {

    BudgetUserDTO toDTO(BudgetUser budgetUser);

    @Mapping(target = "id", ignore = true)
    BudgetUser fromDTO(BudgetUserDTO budgetUserDTO);
}
