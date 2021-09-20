package com.kaganarmagan.hititinterviewassignment.repository;


import com.kaganarmagan.hititinterviewassignment.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IItemRepository extends JpaRepository<Item,Long> {

    List<Item> getItemsByCustomer_Id(Long id);



}
