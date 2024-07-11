package org.example.practice.Repositories;

import org.example.practice.Table.Product;
import org.hibernate.engine.jdbc.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getAllBySizeOrderById(Size sizeValue);
}
