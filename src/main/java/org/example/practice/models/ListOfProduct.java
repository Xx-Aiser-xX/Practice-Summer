package org.example.practice.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "list_of_goods")
public class ListOfProduct extends BaseEntity {

    private Product product;
    private int theQuantityOfTheProduct;
    private Set<Manufactures> manufactures;
    private Set<Order> order;


    public ListOfProduct(Product product, int theQuantityOfTheProduct){
        this.product = product;
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    protected ListOfProduct() {

    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_code", referencedColumnName = "id")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


    @Column(name = "number_of_items")
    public int getTheQuantityOfTheProduct() { return theQuantityOfTheProduct;}
    public void setTheQuantityOfTheProduct(int theQuantityOfTheProduct) {
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    @OneToMany(mappedBy = "listOfProduct", targetEntity = Manufactures.class)
    public Set<Manufactures> getManufactures() {
        return manufactures;
    }
    public void setManufactures(Set<Manufactures> manufactures) {
        this.manufactures = manufactures;
    }

    @OneToMany(mappedBy = "listOfProduct", targetEntity = Order.class)
    public Set<Order> getOrder() {
        return order;
    }
    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
