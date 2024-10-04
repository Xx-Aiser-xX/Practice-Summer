package org.example.practice.dto;

//import lombok.Getter;
//import lombok.Setter;
import org.example.practice.models.BranchOfTheOrganization;
import org.example.practice.models.Human;

import java.util.Date;

//@Getter
//@Setter
public class EmployeeDto {
    private int id;
    private BranchOfTheOrganization branchOfTheOrganization;
    private Human human;
    private Date dataOfHiring;
    private double wages;
    private String post;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getWages() {
        return wages;
    }
    public void setWages(double wages) {
        this.wages = wages;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public Date getDataOfHiring() {
        return dataOfHiring;
    }
    public void setDataOfHiring(Date dataOfHiring) {
        this.dataOfHiring = dataOfHiring;
    }

    public Human getHuman() {
        return human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }

    public BranchOfTheOrganization getBranchOfTheOrganization() {
        return branchOfTheOrganization;
    }
    public void setBranchOfTheOrganization(BranchOfTheOrganization branchOfTheOrganization) {
        this.branchOfTheOrganization = branchOfTheOrganization;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
