package com.example.giftproject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "gift_history")
public class GiftHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member user;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Member from;

    @ManyToOne
    @JoinColumn(name = "gift_id")
    private Gift gift;

}