package org.example.practice.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.practice.Table.BranchOfTheOrganization;
import org.example.practice.Repositories.BranchOfTheOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchOfTheOrganizationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(BranchOfTheOrganization branch) {
        entityManager.persist(branch);
    }

    @Transactional
    public void saveAllBranch(List<BranchOfTheOrganization> branchs) {
        for (BranchOfTheOrganization branch : branchs) {
            entityManager.persist(branch);
        }
    }

    @Transactional
    public void update(BranchOfTheOrganization branch) {
        entityManager.merge(branch);
    }

    public BranchOfTheOrganization findById(int id) {
        return entityManager.find(BranchOfTheOrganization.class, id);
    }

    public List<BranchOfTheOrganization> findAll() {
        return entityManager.createQuery("from BranchOfTheOrganization", BranchOfTheOrganization.class).getResultList();
    }

    @Transactional
    public void deleteById(int id) {
        BranchOfTheOrganization branch = findById(id);
        if (branch != null) {
            entityManager.remove(branch);
        }
    }
}
