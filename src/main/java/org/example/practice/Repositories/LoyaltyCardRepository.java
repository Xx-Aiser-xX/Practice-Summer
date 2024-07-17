package org.example.practice.Repositories;

import org.example.practice.Table.LoyaltyCard;
import org.springframework.stereotype.Repository;

@Repository
public class LoyaltyCardRepository extends BaseRepository<LoyaltyCard> {

    public LoyaltyCardRepository() {
        super(LoyaltyCard.class);
    }
}