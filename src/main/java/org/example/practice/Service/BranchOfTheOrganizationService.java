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
public class BranchOfTheOrganizationService implements BaseService<BranchOfTheOrganizationDto> {

    @PersistenceContext
    private EntityManager entityManager;
    private final BranchOfTheOrganizationRepository branchRepo;


    @Autowired
    public BranchOfTheOrganizationService(BranchOfTheOrganizationRepository branchRepo) {
        this.branchRepo = branchRepo;
    }
    @Transactional
    @Override
    public void create(BranchOfTheOrganizationDto branchOfTheOrganizationDto) {
        entityManager.merge(branchOfTheOrganizationDto);
    }

    @Transactional
    @Override
    public List<BranchOfTheOrganizationDto> getAll() {
        return entityManager.createQuery("from BranchOfTheOrganization", BranchOfTheOrganizationDto.class).getResultList();
    }

    @Transactional
    @Override
    public BranchOfTheOrganizationDto getById(int id) {
        return entityManager.find(BranchOfTheOrganizationDto.class, id);
    }

    @Transactional
    @Override
    public void update(BranchOfTheOrganizationDto branchOfTheOrganizationDto) {
        entityManager.merge(branchOfTheOrganizationDto);
    }

    public List<Object[]> findBranchProfits() {
        return branchRepo.findBranchProfits();
    }


}
