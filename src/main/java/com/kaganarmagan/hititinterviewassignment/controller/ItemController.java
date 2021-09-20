package com.kaganarmagan.hititinterviewassignment.controller;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.ItemListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.ItemRequestDTO;
import com.kaganarmagan.hititinterviewassignment.entity.Item;
import com.kaganarmagan.hititinterviewassignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(("/item"))
@RequiredArgsConstructor
public class ItemController {
    private final Logger logger= LoggerFactory.getLogger(ItemController.class) ;
    private final ItemService itemService;



    @GetMapping("/{id}")
    public String itemsByCustomer(Model model,@PathVariable long id){
        model.addAttribute("items",itemService.findItemsByCustomerId(id));

        return "itemsbycustomer";
    }

    @GetMapping("/register/{id}")
    public String addItem(Model model,@PathVariable long id){
        model.addAttribute("item",new ItemRequestDTO()).addAttribute("customer_id",id);
        return "additem";
    }

    @PostMapping("/additem/")
    public String saveCustomer(@Valid @ModelAttribute("item")  ItemRequestDTO item , BindingResult result){
        if(result.hasErrors()){
            return "additem";
        }
        itemService.save(item);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        itemService.deleteById(id);
        return "redirect:/item/"+id;
    }


   /* @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @Valid ItemListDTO itemListDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            return "updateitem";
        }

        itemService.update(itemListDTO);
        return "redirect:/index";
    }*/
}
