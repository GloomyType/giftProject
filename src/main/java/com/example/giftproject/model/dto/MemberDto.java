package com.example.giftproject.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberDto {
    private Long id;
    private String name;
    private String email;

}