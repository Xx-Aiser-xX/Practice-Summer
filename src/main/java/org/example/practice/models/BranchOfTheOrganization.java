package org.example.practice.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch_of_the_organization")
public class BranchOfTheOrganization  extends BaseEntity{

    private int mainBranch;
    private String nameBranch;
    private String phone;
    private String address;
    private Set<Employee> employee;


    public BranchOfTheOrganization(int mainBranch, String nameBranch, String phone, String address){
        this.mainBranch = mainBranch;
        this.nameBranch = nameBranch;
        this.phone = phone;
        this.address = address;
    }

    protected BranchOfTheOrganization() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch")
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    @Column(name = "main_file")
    public int getMainBranch() { return mainBranch;}
    public void setMainBranch(int mainBranch) { this.mainBranch = mainBranch;}

    @Column(name = "filial_name")
    public String getNameBranch() { return nameBranch;}
    public void setNameBranch(String nameBranch) { this.nameBranch = nameBranch;}

    @Column(name = "phone")
    public String getPhone() { return phone;}
    public void setPhone(String phone) { this.phone = phone;}

    @Column(name = "address")
    public String getAddress() { return address;}
    public void setAddress(String address) { this.address = address;}

    @OneToMany(mappedBy = "branchOfTheOrganization", targetEntity = Employee.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
