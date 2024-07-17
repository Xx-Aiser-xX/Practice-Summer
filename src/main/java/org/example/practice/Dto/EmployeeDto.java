package org.example.practice.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.practice.Relationship.Manufactures;
import org.example.practice.Table.BranchOfTheOrganization;
import org.example.practice.Table.Human;

import java.util.Date;
import java.util.Set;

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
