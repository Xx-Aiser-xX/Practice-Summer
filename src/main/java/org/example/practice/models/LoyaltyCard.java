package org.example.practice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "loyalty_card")
public class LoyaltyCard extends BaseEntity {

    private int points;
    private String contactDetails;
    private String ownerStatus;
    private Client client;

    public LoyaltyCard(int points, String contactDetails, String ownerStatus){
        this.points = points;
        this.contactDetails = contactDetails;
        this.ownerStatus = ownerStatus;
    }

    protected LoyaltyCard() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loyalty_card")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}


    @Column(name = "number_of_points")
    public int getPoints() { return points;}
    public void setPoints(int points) { this.points = points;}

    @Column(name = "contact_details")
    public String getContactDetails() { return contactDetails;}
    public void setContactDetails(String contactDetails) { this.contactDetails = contactDetails;}

    @Column(name = "owner_status")
    public String getOwnerStatus() { return ownerStatus;}
    public void setOwnerStatus(String ownerStatus) { this.ownerStatus = ownerStatus;}

    @OneToOne(mappedBy = "loyaltyCard")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
