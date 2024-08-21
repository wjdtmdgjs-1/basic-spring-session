package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> list = new ArrayList<>();
        for (Member member : members) {
             list.add(new MemberSimpleResponseDto(member.getId(),member.getName()));
        }
        return list;
    }

    public MemberDetailResponseDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));
        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long id, MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));
        member.update(memberUpdateRequestDto.getName());
        return new MemberUpdateResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("멤버가 없습니다."));
        memberRepository.delete(member);
    }
}
