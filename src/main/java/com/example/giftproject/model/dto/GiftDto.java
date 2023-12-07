package com.example.giftproject.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class GiftDto {
    private Long id;
    private String description;
    private BigDecimal amount;
}
