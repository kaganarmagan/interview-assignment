package com.kaganarmagan.hititinterviewassignment.controller;

import com.github.rozidan.springboot.logger.Loggable;
import com.kaganarmagan.hititinterviewassignment.dto.ItemListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.ItemRequestDTO;
import com.kaganarmagan.hititinterviewassignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(("/item"))
@RequiredArgsConstructor
@Loggable(entered = true)
public class ItemController {
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


    @PostMapping("/additem/{customerId}")
    public String saveItem(@PathVariable long customerId ,@Valid @ModelAttribute("item") ItemRequestDTO item , BindingResult result){
        System.out.println(item);
        if(result.hasErrors()){
            return "additem";
        }
        itemService.save(item);
        return "redirect:/item/"+customerId;
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id){
        itemService.deleteById(id);
        return "redirect:/item/"+id;
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable long id,Model model){
        System.out.println(itemService.findById(id));
        model.addAttribute("item",itemService.findById(id));
        return "updateitem";
    }


    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable int id, @Valid @ModelAttribute("item") ItemListDTO item, BindingResult result){
        System.out.println(item);
        if(result.hasErrors()){
            return "updateitem";
        }
        itemService.update(item);
        return "redirect:/item/"+id;
    }
}
