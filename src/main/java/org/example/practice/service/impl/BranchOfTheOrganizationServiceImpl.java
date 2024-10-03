package org.example.practice.service.impl;

import org.example.practice.exceptions.BranchNotFoundException;
import org.example.practice.repositories.BranchOfTheOrganizationRepository;
import org.example.practice.service.BranchOfTheOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfTheOrganizationServiceImpl implements BranchOfTheOrganizationService {

    private final BranchOfTheOrganizationRepository branchRepo;

    @Autowired
    public BranchOfTheOrganizationServiceImpl(BranchOfTheOrganizationRepository branchRepo) {
        this.branchRepo = branchRepo;
    }

    @Override
    public List<Object[]> findBranchProfits() {
        List<Object[]> profits = branchRepo.findBranchProfits();
        if (profits.isEmpty()) {
            throw new BranchNotFoundException("No branches found or profits not available.");
        }
        return branchRepo.findBranchProfits();
    }
}