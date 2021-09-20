package com.kaganarmagan.hititinterviewassignment.mappers;



import com.kaganarmagan.hititinterviewassignment.dto.ItemListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.ItemRequestDTO;
import com.kaganarmagan.hititinterviewassignment.entity.Item;
import com.kaganarmagan.hititinterviewassignment.service.ItemService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class ItemMapper {
    @Autowired
    public ItemService itemService;

    @Mapping(target = "customer",expression = "java(itemService.findCustomerById(itemListDTO.getCustomerId()))")
    public abstract Item fromItemListDTOtoItem(ItemListDTO itemListDTO);
    @Mapping(target = "customer",expression = "java(itemService.findCustomerById(itemDTO.getCustomerId()))")
    public abstract Item fromItemListDTOtoItem(ItemRequestDTO itemDTO);

    @Mapping(target = "customerId",source = "item.customer.id")
    public abstract ItemListDTO fromItemToItemRequestDTO(Item item);

}
