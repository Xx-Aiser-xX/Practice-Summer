package org.example.practice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchOfTheOrganizationDto {
    private int id;
    private int mainBranch;
    private String nameBranch;
    private String phone;
    private String address;
}
