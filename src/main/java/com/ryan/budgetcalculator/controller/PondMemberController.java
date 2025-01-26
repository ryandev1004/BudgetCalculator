package com.ryan.budgetcalculator.controller;

import com.ryan.budgetcalculator.entity.dto.PondMemberCreateDTO;
import com.ryan.budgetcalculator.entity.dto.PondMemberDTO;
import com.ryan.budgetcalculator.entity.dto.PondMemberUpdateDTO;
import com.ryan.budgetcalculator.service.PondMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PondMemberController {

    private final PondMemberService pondMemberService;

    @GetMapping("members")
    public ResponseEntity<List<PondMemberDTO>> getAllPondMembers() {
        return ResponseEntity.ok().body(pondMemberService.getAllPondMembers());
    }

    @GetMapping("members/{id}")
    public ResponseEntity<PondMemberDTO> getPondMember(@PathVariable UUID id) {
        return ResponseEntity.ok().body(pondMemberService.getPondMemberById(id));
    }

    @PostMapping("members")
    public ResponseEntity<PondMemberDTO> addPondMember(@RequestBody PondMemberCreateDTO pondMemberCreateDTO) {
        return ResponseEntity.ok().body(pondMemberService.createPondMember(pondMemberCreateDTO));
    }

    @PatchMapping("members/{id}")
    public ResponseEntity<PondMemberDTO> updatePondMember(@PathVariable UUID id, @RequestBody PondMemberUpdateDTO pondMemberUpdateDTO) {
        return ResponseEntity.ok().body(pondMemberService.updatePondMember(id, pondMemberUpdateDTO));
    }

    @DeleteMapping("members/{id}")
    public ResponseEntity<UUID> deletePondMember(@PathVariable UUID id) {
        pondMemberService.deletePondMember(id);
        return ResponseEntity.ok().body(id);
    }


}
