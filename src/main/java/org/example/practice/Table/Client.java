package org.example.practice.Table;


import jakarta.persistence.*;
import org.example.practice.Relationship.Order;

import java.util.Set;

@Entity
@Table(name = "клиент")
public class Client extends BaseEntity {
    private int id;
    private Human human;
    private LoyaltyCard loyaltyCard;
    private Set<Order> order;


    public Client(Human human, LoyaltyCard loyaltyCard){
        this.human = human;
        this.loyaltyCard = loyaltyCard;
    }

    public Client() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_клиента")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_человека", referencedColumnName = "id_человека")
    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }


    @OneToOne
    @JoinColumn(name = "id_карты_лояльности")
    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }
    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @OneToMany(mappedBy = "client", targetEntity = Order.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Order> getOrder() {
        return order;
    }
    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
