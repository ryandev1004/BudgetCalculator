package com.ryan.budgetcalculator.examples.controller;

import com.ryan.budgetcalculator.examples.entity.dto.PondMemberCreateDTO;
import com.ryan.budgetcalculator.examples.entity.dto.PondMemberDTO;
import com.ryan.budgetcalculator.examples.entity.dto.PondMemberUpdateDTO;
import com.ryan.budgetcalculator.examples.service.PondMemberService;
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

    @GetMapping("members/s-rank")
    public ResponseEntity<List<PondMemberDTO>> getAllPondMemberSRanks() {
        return ResponseEntity.ok().body(pondMemberService.getPondMemberBySRank());
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
