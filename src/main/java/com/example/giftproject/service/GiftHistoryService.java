package com.example.giftproject.service;

import com.example.giftproject.model.dto.GiftDto;
import com.example.giftproject.model.dto.MemberDto;
import com.example.giftproject.model.entity.Gift;
import com.example.giftproject.model.entity.GiftHistory;
import com.example.giftproject.model.entity.Member;
import com.example.giftproject.repository.GiftHistoryRepository;
import com.example.giftproject.repository.GiftRepository;
import com.example.giftproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GiftHistoryService {
    private final GiftHistoryRepository giftHistoryRepository;
    private final GiftRepository giftRepository;
    public GiftHistoryService(GiftHistoryRepository giftHistoryRepository,GiftRepository giftRepository) {
        this.giftHistoryRepository = giftHistoryRepository;
        this.giftRepository = giftRepository;
    }

    public List<GiftHistory> getGiftHistoryByUserId(Long userId) {
        return giftHistoryRepository.findByUserId(userId);
    }
    public List<Gift> getBestSellingGifts() {
        List<Gift> allGifts = giftHistoryRepository.findBestSellingGifts();
        return allGifts.subList(0, Math.min(allGifts.size(), 3));
    }

    public GiftDto getGiftInfo(Long giftId) {
        Gift gift = giftRepository.findById(giftId)
                .orElseThrow(() -> new NoSuchElementException("Gift not found with id: " + giftId));

        return GiftDto.builder()
                .id(gift.getId())
                .amount(gift.getAmount())
                .description(gift.getDescription())
                .build();
    }
}
