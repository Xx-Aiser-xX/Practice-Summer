package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Dto.BranchOfTheOrganizationDto;
import org.example.practice.Repositories.BranchOfTheOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchOfTheOrganizationService {

    @PersistenceContext
    private EntityManager entityManager;
    private final BranchOfTheOrganizationRepository branchRepo;


    @Autowired
    public BranchOfTheOrganizationService(BranchOfTheOrganizationRepository branchRepo) {
        this.branchRepo = branchRepo;
    }

    public List<Object[]> findBranchProfits() {
        return branchRepo.findBranchProfits();
    }


}
