package com.kaganarmagan.hititinterviewassignment.service;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.CustomerRequestDTO;
import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import com.kaganarmagan.hititinterviewassignment.mappers.CustomerMapper;
import com.kaganarmagan.hititinterviewassignment.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService implements IBaseService<Customer, CustomerRequestDTO, CustomerListDTO> {
    @Autowired
    private  ICustomerRepository repository;
    @Autowired
    private  CustomerMapper mapper;





    @Override
    public  Customer save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=mapper.fromCustomerRequestDTOtoCustomer(customerRequestDTO);

        return repository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerListDTO> findAll() {
        List<CustomerListDTO> response= new ArrayList<>();

        for (Customer c:repository.findAll()
             ) {
            CustomerListDTO customerListDTO = mapper.fromCustomertoCustomerListDTO(c);
            response.add(customerListDTO);
        }
        return response;
    }
    @Transactional
    public List<CustomerListDTO> findAllOrderByName(){
        List<CustomerListDTO> response=new ArrayList<>();
        for (Customer c:repository.findAllByOrderByNameAsc()
             ) {
                CustomerListDTO dto= mapper.fromCustomertoCustomerListDTO(c);
            response.add(dto);

        }
        return response;
    }

    @Override
    @Transactional
    public String deleteById(Long id) {

        repository.deleteById(id);
        return "Deleted...";
    }



}
