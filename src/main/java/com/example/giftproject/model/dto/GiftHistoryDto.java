package com.example.giftproject.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GiftHistoryDto {
    private Long id;
    private MemberDto user;
    private MemberDto from;
    private GiftDto gift;
}
