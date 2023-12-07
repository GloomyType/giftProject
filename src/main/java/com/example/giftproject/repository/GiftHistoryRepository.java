package com.example.giftproject.repository;

import com.example.giftproject.model.entity.Gift;
import com.example.giftproject.model.entity.GiftHistory;
import com.example.giftproject.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface GiftHistoryRepository extends JpaRepository<GiftHistory, Long> {
    List<GiftHistory> findByUserId(Long userId);
    @Query(value = "SELECT g FROM Gift g JOIN GiftHistory gh ON g.id = gh.gift.id GROUP BY gh.gift.id ORDER BY COUNT(gh.gift.id) DESC")
    List<Gift> findBestSellingGifts();
}