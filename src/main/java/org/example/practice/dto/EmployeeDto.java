package org.example.practice.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.practice.models.BranchOfTheOrganization;
import org.example.practice.models.Human;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private int id;
    private BranchOfTheOrganization branchOfTheOrganization;
    private Human human;
    private Date dataOfHiring;
    private double wages;
    private String post;
    private Date birthday;
}
