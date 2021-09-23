package com.kaganarmagan.hititinterviewassignment.controller;

import com.kaganarmagan.hititinterviewassignment.dto.ItemRequestDTO;
import com.kaganarmagan.hititinterviewassignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(("/item"))
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final Logger logger= LoggerFactory.getLogger(ItemController.class) ;
    private final ItemService itemService;



    @GetMapping("/{id}")
    public String itemsByCustomer(Model model,@PathVariable long id){
        model.addAttribute("items",itemService.findItemsByCustomerId(id)).addAttribute("customer_id",id);

        return "itemsbycustomer";
    }

    @GetMapping("/additem/{id}")
    public String addItem(@PathVariable long id,Model model){

        model.addAttribute("item",new ItemRequestDTO(id));
        return "additem";
    }

    @PostMapping("/additem/{id}")
    public String saveItem(@PathVariable long id, @ModelAttribute("item") @Valid ItemRequestDTO item , BindingResult result){

        if(result.hasErrors()){
            return "additem/"+id;
        }
        itemService.save(item);
        return "redirect:/item/"+id;
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id){
        itemService.deleteById(id);
        return "redirect:/item/"+id;
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable long id,Model model){
        model.addAttribute("item",itemService.findById(id));
        return "updateitem";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("item")@Valid ItemRequestDTO item, BindingResult result, Model model){
        if(result.hasErrors()){
            return "updateitem";
        }

        itemService.save(item);
        return "redirect:/index";
    }
}
