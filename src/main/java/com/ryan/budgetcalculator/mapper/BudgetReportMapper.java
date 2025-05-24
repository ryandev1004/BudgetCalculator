package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.BudgetReport;
import com.ryan.budgetcalculator.entity.dto.BudgetReportCreateDTO;
import com.ryan.budgetcalculator.entity.dto.BudgetReportDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BudgetReportMapper {

    BudgetReportDTO toDTO(BudgetReport budgetReport);

    @Mapping(target = "reportId", ignore = true)
    BudgetReport fromCreateDTO(BudgetReportCreateDTO dto);

}
