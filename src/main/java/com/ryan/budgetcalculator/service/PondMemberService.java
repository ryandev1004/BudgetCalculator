package com.ryan.budgetcalculator.service;

import com.ryan.budgetcalculator.entity.PondMember;
import com.ryan.budgetcalculator.entity.dto.PondMemberCreateDTO;
import com.ryan.budgetcalculator.entity.dto.PondMemberDTO;
import com.ryan.budgetcalculator.entity.dto.PondMemberUpdateDTO;
import com.ryan.budgetcalculator.mapper.PondMemberMapper;
import com.ryan.budgetcalculator.repository.PondMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PondMemberService {

    private final PondMemberRepository pondMemberRepository;
    private final PondMemberMapper pondMemberMapper;

    public List<PondMemberDTO> getAllPondMembers() {
        List<PondMember> allMembers = pondMemberRepository.findAll();
        return allMembers.stream()
                .map(pondMemberMapper::toDtoFromPondMember)
                .toList();
    }

    public PondMemberDTO getPondMemberById(UUID id) {
        PondMember pondMember = pondMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pond member not found"));
        return pondMemberMapper.toDtoFromPondMember(pondMember);
    }

    public PondMemberDTO createPondMember(PondMemberCreateDTO pondMemberCreateDTO) {
        PondMember pondMember = pondMemberMapper.toPondMemberFromCreateDto(pondMemberCreateDTO);
        PondMember savedPondMember = pondMemberRepository.save(pondMember);
        return pondMemberMapper.toDtoFromPondMember(savedPondMember);
    }

    public PondMemberDTO updatePondMember(UUID id, PondMemberUpdateDTO pondMemberUpdateDTO) {
        PondMember pondMember = pondMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pond member not found"));
        if (pondMemberUpdateDTO.getAge() != pondMember.getAge()) {
            pondMember.setAge(pondMemberUpdateDTO.getAge());
        }
        if (pondMemberUpdateDTO.getRank() != pondMember.getRank()) {
            pondMember.setRank(pondMemberUpdateDTO.getRank());
        }
        PondMember updatedPondMember = pondMemberRepository.save(pondMember);
        return pondMemberMapper.toDtoFromPondMember(updatedPondMember);
    }

    public void deletePondMember(UUID id) {
        pondMemberRepository.deleteById(id);
    }

}
