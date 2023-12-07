package com.example.giftproject.controller;

import com.example.giftproject.model.dto.GiftDto;
import com.example.giftproject.model.entity.Gift;
import com.example.giftproject.model.entity.GiftHistory;
import com.example.giftproject.service.GiftHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gift")
public class GiftHistoryController {

    private final GiftHistoryService giftHistoryService;

    public GiftHistoryController(GiftHistoryService giftHistoryService) {
        this.giftHistoryService = giftHistoryService;
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<GiftHistory>> getGiftHistoryByUserId(@PathVariable Long userId) {
        List<GiftHistory> giftHistoryList = giftHistoryService.getGiftHistoryByUserId(userId);
        return new ResponseEntity<>(giftHistoryList, HttpStatus.OK);
    }

    @GetMapping("/best-selling")
    public ResponseEntity<List<Gift>> getTop3BestSellingGifts() {
        List<Gift> top3BestSellingGifts = giftHistoryService.getBestSellingGifts();
        return new ResponseEntity<>(top3BestSellingGifts, HttpStatus.OK);
    }

    @GetMapping("/info/{giftId}")
    public ResponseEntity<GiftDto> getGiftInfo(@PathVariable Long giftId) {
        GiftDto giftDto = giftHistoryService.getGiftInfo(giftId);
        return ResponseEntity.ok(giftDto);
    }
}
