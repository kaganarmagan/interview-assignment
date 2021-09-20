package com.kaganarmagan.hititinterviewassignment.service;

import com.kaganarmagan.hititinterviewassignment.dto.ItemListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.ItemRequestDTO;
import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import com.kaganarmagan.hititinterviewassignment.entity.Item;
import com.kaganarmagan.hititinterviewassignment.mappers.ItemMapper;
import com.kaganarmagan.hititinterviewassignment.repository.ICustomerRepository;
import com.kaganarmagan.hititinterviewassignment.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class ItemService implements IBaseService<Item, ItemRequestDTO, ItemListDTO> {
    @Autowired
    public  IItemRepository repository;

    @Autowired
    public ItemMapper mapper;

    @Autowired
    public ICustomerRepository customerRepository;



    @Override
    @Transactional
    public Item save(ItemRequestDTO itemDTO) {
        Item item=mapper.fromItemListDTOtoItem(itemDTO);


        return repository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemListDTO> findAll() {

        List<ItemListDTO> response= new ArrayList<>();

        for (Item i:repository.findAll()
        ) {
            ItemListDTO itemListDTO = mapper.fromItemToItemRequestDTO(i);
            response.add(itemListDTO);
        }
        return response;

    }

    @Override
    @Transactional
    public String deleteById(Long id) {
        repository.deleteById(id);
        return "Deleted";
    }
    @Transactional(readOnly = true)
    public Customer findCustomerById(Long id){

        return customerRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<ItemListDTO> findItemsByCustomerId(Long id){
        List<ItemListDTO> response= new ArrayList<>();

        for (Item i:repository.getItemsByCustomer_Id(id)
        ) {
            ItemListDTO itemListDTO = mapper.fromItemToItemRequestDTO(i);
            response.add(itemListDTO);
        }
        return response;


    }

    public List<Item> findItemsByItemIds(List<Long> itemIds) {

        return repository.findAllById(itemIds);
    }

    public List<Long> findItemIds(List<Item> items) {
        List<Long> response=new ArrayList<>();
        if (items.isEmpty()){
            return response;
        }
        for (Item item:items
             ) {
            if(item!=null){
                response.add(item.getId());
            }else{
                return response;
            }

        }
        return response;
    }

    public Integer findItemNumber(List<Item> items) {
        return items.size();
    }


}
