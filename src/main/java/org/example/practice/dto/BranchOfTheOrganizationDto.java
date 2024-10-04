package org.example.practice.dto;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class BranchOfTheOrganizationDto {
    private int id;
    private int mainBranch;
    private String nameBranch;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getMainBranch() {
        return mainBranch;
    }
    public void setMainBranch(int mainBranch) {
        this.mainBranch = mainBranch;
    }

    public String getNameBranch() {
        return nameBranch;
    }
    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
