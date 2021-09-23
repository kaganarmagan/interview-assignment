package com.kaganarmagan.hititinterviewassignment.repository;

import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByOrderByNameAsc();

    @Query(value = "select distinct c.city from Customer c ")
    List<String> findDistinctByCity();

    List<Customer> findCustomersByCity(String city);

}
