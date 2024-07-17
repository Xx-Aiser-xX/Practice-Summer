package org.example.practice.Table;

import jakarta.persistence.*;
import org.example.practice.Relationship.Manufactures;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "сотрудник")
public class Employee extends BaseEntity {
    private int id;
    private BranchOfTheOrganization branchOfTheOrganization;
    private Human human;
    private Date dataOfHiring;
    private double wages;
    private String post;
    private Date birthday;
    private Set<Manufactures> manufactures;


    public Employee(BranchOfTheOrganization branchOfTheOrganization, Human human,
                    Date dataOfHiring, double wages, String post, Date birthday){

        this.branchOfTheOrganization = branchOfTheOrganization;
        this.human = human;
        this.dataOfHiring = dataOfHiring;
        this.wages = wages;
        this.post = post;
        this.birthday = birthday;
    }

    public Employee() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_сотрудника")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}


    @ManyToOne(optional = false)
    @JoinColumn(name = "филиал", referencedColumnName = "филиал")
    public BranchOfTheOrganization getBranchOfTheOrganization() {
        return branchOfTheOrganization;
    }
    public void setBranchOfTheOrganization(BranchOfTheOrganization branchOfTheOrganization) {
        this.branchOfTheOrganization = branchOfTheOrganization;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_человека", referencedColumnName = "id_человека")
    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }


    @Column(name = "дата_найма")
    @Temporal(TemporalType.DATE)
    public Date getDataOfHiring() { return dataOfHiring;}
    public void setDataOfHiring(Date dataOfHiring) {
        this.dataOfHiring = dataOfHiring;
    }

    @Column(name = "заработная_плата")
    public double getWages() { return wages;}
    public void setWages(double wages) { this.wages = wages;}

    @Column(name = "должность")
    public String getPost() { return post;}
    public void setPost(String post) { this.post = post;}

    @Column(name = "дата_рождения")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() { return birthday;}
    public void setBirthday(Date birthday) { this.birthday = birthday;}

    @OneToMany(mappedBy = "employee", targetEntity = Manufactures.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Manufactures> getManufactures() {
        return manufactures;
    }
    public void setManufactures(Set<Manufactures> manufactures) {
        this.manufactures = manufactures;
    }
}
