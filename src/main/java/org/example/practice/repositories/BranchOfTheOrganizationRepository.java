package org.example.practice.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BranchOfTheOrganizationRepository {
    List<Object[]> findBranchProfits();
}
