package org.example.practice.Relationship;

import jakarta.persistence.*;
import org.example.practice.Table.BaseEntity;
import org.example.practice.Table.Client;
import org.example.practice.Table.ListOfProduct;

import java.util.Date;

@Entity
@Table(name = "заказ")
public class Order extends BaseEntity {
    private int id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_заказа")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_клиента", referencedColumnName = "id_клиента")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_товара", referencedColumnName = "id_товара")
    public ListOfProduct getListOfProduct() {
        return listOfProduct;
    }
    public void setListOfProduct(ListOfProduct listOfProduct) {
        this.listOfProduct = listOfProduct;
    }

    @Column(name = "дата")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "кол_во_товара")
    public int getTheQuantityOfTheProduct() {
        return theQuantityOfTheProduct;
    }
    public void setTheQuantityOfTheProduct(int theQuantityOfTheProduct) {
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }
}
