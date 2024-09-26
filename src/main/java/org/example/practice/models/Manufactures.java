package org.example.practice.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "manufactures")
public class Manufactures extends BaseEntity {
    private int id;
    private Employee employee;
    private ListOfProduct listOfProduct;
    private Timestamp date;
    private Integer quantityOfGoodsProduced;
    private Timestamp expirationDate;


    public Manufactures(int id, Employee employee, ListOfProduct listOfProduct,
                        Timestamp date, int quantityOfGoodsProduced, Timestamp expirationDate){
        this.id = id;
        this.employee = employee;
        this.listOfProduct = listOfProduct;
        this.date = date;
        this.quantityOfGoodsProduced = quantityOfGoodsProduced;
        this.expirationDate = expirationDate;
    }

    protected Manufactures() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_party")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
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
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "number_of_manufactured_goods")
    public Integer getQuantityOfGoodsProduced() {
        return quantityOfGoodsProduced;
    }
    public void setQuantityOfGoodsProduced(Integer quantityOfGoodsProduced) {
        this.quantityOfGoodsProduced = quantityOfGoodsProduced;
    }

    @Column(name = "expiration_date")
    public Timestamp getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }
}
