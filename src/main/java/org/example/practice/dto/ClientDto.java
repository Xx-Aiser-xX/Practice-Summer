package org.example.practice.dto;

//import lombok.Getter;
//import lombok.Setter;
import org.example.practice.models.Human;
import org.example.practice.models.LoyaltyCard;

//@Getter
//@Setter
public class ClientDto {
    private int id;
    private Human human;
    private LoyaltyCard loyaltyCard;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }

    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }
    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}
