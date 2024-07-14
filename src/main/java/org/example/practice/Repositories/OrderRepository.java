package org.example.practice.Repositories;

import org.example.practice.Relationship.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

//    // поиск заказов по id клинета
//    @Query("SELECT o FROM Order o WHERE o.client.id = :clientId")
//    List<Order> findAllOrdersByClientId(@Param("clientId") Integer clientId);
//
//    //список заказов в определённую дату
//    @Query("SELECT o FROM Order o WHERE o.date = :date")
//    List<Order> findOrdersByDate(@Param("date") Date date);

    @Query("SELECT b.nameBranch, COUNT(o.id) " +
            "FROM Order o " +
            "JOIN o.listOfProduct lp " +
            "JOIN lp.manufactures m " +
            "JOIN m.employee e " +
            "JOIN e.branchOfTheOrganization b " +
            "GROUP BY b.id " +
            "ORDER BY COUNT(o.id) DESC")
    List<Object[]> findOrderCountByBranch();
}