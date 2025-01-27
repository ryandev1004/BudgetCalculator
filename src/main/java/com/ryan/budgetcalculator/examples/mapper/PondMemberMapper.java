package com.ryan.budgetcalculator.examples.mapper;

import com.ryan.budgetcalculator.examples.entity.PondMember;
import com.ryan.budgetcalculator.examples.entity.dto.PondMemberCreateDTO;
import com.ryan.budgetcalculator.examples.entity.dto.PondMemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PondMemberMapper {

    PondMemberDTO toDtoFromPondMember(PondMember pondMember);

    @Mapping(target = "id", ignore = true)
    PondMember toPondMemberFromCreateDto(PondMemberCreateDTO pondMemberCreateDTO);

}
