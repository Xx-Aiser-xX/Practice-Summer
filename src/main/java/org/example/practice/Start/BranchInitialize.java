package org.example.practice.Start;

import org.example.practice.Service.BranchOfTheOrganizationService;
import org.example.practice.Table.BranchOfTheOrganization;

import java.util.Arrays;

public class BranchInitialize {
    private final BranchOfTheOrganizationService branchOfTheOrganizationService;

    public BranchInitialize(BranchOfTheOrganizationService
                                    branchOfTheOrganizationService) {
        this.branchOfTheOrganizationService = branchOfTheOrganizationService;
    }

    public void run(String... args) throws Exception {
        // Добавляем билеты в базу данных через сервис
        branchOfTheOrganizationService.saveAllBranch(Arrays.asList(
                new BranchOfTheOrganization(1  , "Branch1", "+7 987-654-32-11","г.Москва, ул.Образцова, д.22"),
                new BranchOfTheOrganization(1, "Branch2", "+7 123-456-78-99","г.Москва, ул.Снежная, д.16, к.3"),
                new BranchOfTheOrganization(2, "Branch3", "+7 999-888-77-66","г.Москва, ул.Первомайская, д.31")
        ));
    }
}
