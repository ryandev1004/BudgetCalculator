package com.ryan.budgetcalculator.mapper;

import com.ryan.budgetcalculator.entity.PondMember;
import com.ryan.budgetcalculator.entity.dto.PondMemberCreateDTO;
import com.ryan.budgetcalculator.entity.dto.PondMemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PondMemberMapper {

    PondMemberDTO toDtoFromPondMember(PondMember pondMember);

    @Mapping(target = "id", ignore = true)
    PondMember toPondMemberFromCreateDto(PondMemberCreateDTO pondMemberCreateDTO);

}
