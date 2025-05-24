package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BudgetReportMapper {

    BudgetReportDTO toDto(BudgetReport entity);

}
