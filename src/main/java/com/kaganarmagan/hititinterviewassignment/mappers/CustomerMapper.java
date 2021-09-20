package com.kaganarmagan.hititinterviewassignment.mappers;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.CustomerRequestDTO;
import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import com.kaganarmagan.hititinterviewassignment.service.ItemService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    @Autowired
    ItemService itemService;

    //@Mapping(target = "items",expression = "java(itemService.findItemsByItemIds(customerListDTO.getItemIds()))")
    //public abstract Customer fromCustomerDTOtoCustomer(CustomerListDTO customerListDTO);
    @Mapping(target = "trId",expression = "java(Long.parseLong(customerDTO.getTrId()))")
    public abstract Customer fromCustomerRequestDTOtoCustomer(CustomerRequestDTO customerDTO);
    @Mapping(target = "items",expression = "java(itemService.findItemNumber(customer.getItems()))")
    public abstract CustomerListDTO fromCustomertoCustomerListDTO(Customer customer);

}
