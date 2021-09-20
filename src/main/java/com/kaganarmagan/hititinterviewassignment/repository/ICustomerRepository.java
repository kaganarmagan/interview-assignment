package com.kaganarmagan.hititinterviewassignment.repository;

import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer c order by c.name")
    List<Customer> findAllByOrderByNameAsc();

}
