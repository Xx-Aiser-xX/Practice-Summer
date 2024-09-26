package org.example.practice.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.practice.models.Human;
import org.example.practice.models.LoyaltyCard;

@Getter
@Setter
public class ClientDto {
    private int id;
    private Human human;
    private LoyaltyCard loyaltyCard;
}
