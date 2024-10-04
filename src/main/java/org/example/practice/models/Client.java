package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    private Human human;
    private LoyaltyCard loyaltyCard;
    private Set<Order> order;

    public Client(Human human, LoyaltyCard loyaltyCard){
        this.human = human;
        this.loyaltyCard = loyaltyCard;
    }

    protected Client() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_human", referencedColumnName = "id_human")
    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }


    @OneToOne
    @JoinColumn(name = "id_loyalty_card")
    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }
    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @OneToMany(mappedBy = "client", targetEntity = Order.class, cascade = CascadeType.ALL)
    public Set<Order> getOrder() {
        return order;
    }
    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
