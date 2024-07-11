package org.example.practice.Table;


import jakarta.persistence.*;
import org.example.practice.Relationship.Manufactures;
import org.example.practice.Relationship.Order;

import java.util.Set;

@Entity
@Table(name = "список_товаров")
public class ListOfProduct extends BaseEntity {
    private int id;
    private Product product;
    private int theQuantityOfTheProduct;
    private Set<Manufactures> listOfProducts;
    private Set<Order> order;


    public ListOfProduct(Product product, int theQuantityOfTheProduct){
        this.product = product;
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_товара")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}


    @ManyToOne(optional = false)
    @JoinColumn(name = "код_товара", referencedColumnName = "код_товара")
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }


    @Column(name = "кол_во_товара")
    public int getTheQuantityOfTheProduct() { return theQuantityOfTheProduct;}
    public void setTheQuantityOfTheProduct(int theQuantityOfTheProduct) {
        this.theQuantityOfTheProduct = theQuantityOfTheProduct;
    }

    @OneToMany(mappedBy = "listOfProduct", targetEntity = Manufactures.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Manufactures> getListOfProducts() {
        return listOfProducts;
    }
    public void setListOfProducts(Set<Manufactures> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    @OneToMany(mappedBy = "listOfProduct", targetEntity = Order.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Order> getOrder() {
        return order;
    }
    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}
