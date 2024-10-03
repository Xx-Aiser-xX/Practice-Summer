package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private Client client;
    private ListOfProduct listOfProduct;
    private Date date;
    private int theQuantityOfTheProduct;


    public Order(int id, Client client, ListOfProduct listOfProduct,
                 Date date, int theQuantityOfTheProduct){
        this.id = id;
        this.client = client;
        this.listOfProduct = listOfProduct;
        this.date = date;
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    protected Order() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    public ListOfProduct getListOfProduct() {
        return listOfProduct;
    }
    public void setListOfProduct(ListOfProduct listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "number_of_items")
    public int getTheQuantityOfTheProduct() {
        return theQuantityOfTheProduct;
    }
    public void setTheQuantityOfTheProduct(int theQuantityOfTheProduct) {
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }
}
