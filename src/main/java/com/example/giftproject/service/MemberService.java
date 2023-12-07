package com.example.giftproject.service;

import com.example.giftproject.model.dto.MemberDto;
import com.example.giftproject.model.entity.Member;
import com.example.giftproject.repository.GiftHistoryRepository;
import com.example.giftproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberDto getMemberProfile(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Member not found with id: " + userId));

        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}