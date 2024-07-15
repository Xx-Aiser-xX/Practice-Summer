package org.example.practice.Service;
import org.example.practice.Relationship.Manufactures;
import org.example.practice.Repositories.ManufacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManufacturesService {

    private final ManufacturesRepository manufacturesRepository;

    @Autowired
    public ManufacturesService(ManufacturesRepository manufacturesRepository) {
        this.manufacturesRepository = manufacturesRepository;
    }

    public List<Manufactures> findProductsWithExpiringSoon(Date thresholdDate) {
        return manufacturesRepository.findProductsWithExpiringSoon(thresholdDate);
    }
}
