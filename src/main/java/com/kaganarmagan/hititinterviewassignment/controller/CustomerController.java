package com.kaganarmagan.hititinterviewassignment.controller;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.CustomerRequestDTO;

import com.kaganarmagan.hititinterviewassignment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/index")
    public String findCustomers(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "index";
    }


    @GetMapping("/register")
    public String addCustomer(Model model){
        model.addAttribute("customer",new CustomerRequestDTO());
        return "addcustomer";
    }

    @PostMapping("/addcustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") @DateTimeFormat(pattern = "dd/MM/yyyy") CustomerRequestDTO customer ,BindingResult result){
        if(result.hasErrors()){
            return "addcustomer";
        }
        customerService.save(customer);
        return "redirect:/index";
    }

   /* @GetMapping("/update/{id}")
    public String stratUpdating(@PathVariable long id,Model model){
        model.addAttribute("update",customerService.findById(id));

        return
    }*/



    /*@PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @Valid CustomerListDTO customerListDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            return "updatecustomer";
        }

        customerService.save(customerListDTO);
        return "redirect:/index";
    }*/

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        customerService.deleteById(id);
        return "redirect:/index";
    }



}
