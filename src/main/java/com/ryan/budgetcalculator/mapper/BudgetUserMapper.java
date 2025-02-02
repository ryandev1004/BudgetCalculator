package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.BudgetUser;
import com.ryan.budgetcalculator.entity.dto.BudgetUserCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetUserPatchDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BudgetUserMapper {

    BudgetUserDTO toDTO(BudgetUser budgetUser);

    @Mapping(target = "id", ignore = true)
    BudgetUser fromCreateDTO(BudgetUserCreateDTO budgetUserCreateDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget BudgetUser budgetUser, BudgetUserPatchDTO budgetUserPatchDTO);
}
