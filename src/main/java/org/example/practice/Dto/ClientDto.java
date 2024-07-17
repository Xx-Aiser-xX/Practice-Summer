package org.example.practice.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.practice.Relationship.Order;
import org.example.practice.Table.Human;
import org.example.practice.Table.LoyaltyCard;

import java.util.Set;

@Getter
@Setter
public class ClientDto {
    private int id;
    private Human human;
    private LoyaltyCard loyaltyCard;
}
