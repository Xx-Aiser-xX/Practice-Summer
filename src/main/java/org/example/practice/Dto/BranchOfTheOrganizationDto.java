package org.example.practice.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.practice.Table.Employee;

import java.util.Set;

@Getter
@Setter
public class BranchOfTheOrganizationDto {
    private int id;
    private int mainBranch;
    private String nameBranch;
    private String phone;
    private String address;
}
