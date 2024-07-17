package org.example.practice.Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "товар")
public class Product  extends BaseEntity{
    private int id;
    private String name;
    private double price;
    private Set<ListOfProduct> listOfProducts;


    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "код_товара")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    @Column(name = "название_товара")
    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    @Column(name = "цена")
    public double getPrice() { return price;}
    public void setPrice(double price) { this.price = price;}

    @OneToMany(mappedBy = "product", targetEntity = ListOfProduct.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<ListOfProduct> getListOfProducts() {
        return listOfProducts;
    }
    public void setListOfProducts(Set<ListOfProduct> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
