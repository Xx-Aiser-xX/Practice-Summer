package org.example.practice.service;

import org.example.practice.exceptions.BranchNotFoundException;
import org.example.practice.repositories.BranchOfTheOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfTheOrganizationService {

    private final BranchOfTheOrganizationRepository branchRepo;

    @Autowired
    public BranchOfTheOrganizationService(BranchOfTheOrganizationRepository branchRepo) {
        this.branchRepo = branchRepo;
    }

    public List<Object[]> findBranchProfits() {
        List<Object[]> profits = branchRepo.findBranchProfits();
        if (profits.isEmpty()) {
            throw new BranchNotFoundException("No branches found or profits not available.");
        }
        return branchRepo.findBranchProfits();
    }
}
