package org.example.practice.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "human")
public class Human extends BaseEntity {

    private String firstName;
    private String lastName;
    private String patronymic;
    private Set<Employee> employee;
    private Set<Client> client;


    public Human(String firstName,String lastName,String patronymic){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    protected Human() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_human")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    @Column(name = "name")
    public String getFirstName() { return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName;}

    @Column(name = "surname")
    public String getLastName() { return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName;}

    @Column(name = "patronymic")
    public String getPatronymic() { return patronymic;}
    public void setPatronymic(String patronymic) { this.patronymic = patronymic;}


    @OneToMany(mappedBy = "human", targetEntity = Employee.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }


    @OneToMany(mappedBy = "human", targetEntity = Client.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Client> getClient() {
        return client;
    }
    public void setClient(Set<Client> client) {
        this.client = client;
    }
}
