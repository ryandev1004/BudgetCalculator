package com.ryan.budgetcalculator.entity.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PondMemberDTO {

    private UUID id;
    private String name;
    private char rank;

}
