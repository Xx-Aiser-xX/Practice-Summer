package org.example.practice.Repositories;

import org.example.practice.Relationship.Manufactures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ManufacturesRepository extends JpaRepository<Manufactures, Integer> {

//    // партии товаров,срок годности которых истикает до определённой даты
//    @Query("SELECT m FROM Manufactures m WHERE m.expirationDate <= :expirationDate")
//    List<Manufactures> findManufacturesWithExpiringProducts(@Param("expirationDate") Date expirationDate);
//
//    // партии товаров, произведённых в определённую дату
//    @Query("SELECT m FROM Manufactures m WHERE m.date = :productionDate")
//    List<Manufactures> findManufacturesByProductionDate(@Param("productionDate") Date productionDate);

    @Query("SELECT m FROM Manufactures m WHERE m.expirationDate <= :thresholdDate")
    List<Manufactures> findProductsWithExpiringSoon(@Param("thresholdDate") Date thresholdDate);

}