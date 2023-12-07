package com.example.giftproject.controller;

import com.example.giftproject.model.dto.MemberDto;
import com.example.giftproject.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<MemberDto> getMemberProfile(@PathVariable Long userId) {
        MemberDto memberDto = memberService.getMemberProfile(userId);
        return ResponseEntity.ok(memberDto);
    }
}