package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetReportMapper {

    BudgetReportDTO toDTO(BudgetReport budgetReport);

    @Mapping(target = "reportId", ignore = true)
    @Mapping(target = "reportDate", ignore = true)
    BudgetReport toEntity(BudgetReportDTO budgetReportDTO);
}
