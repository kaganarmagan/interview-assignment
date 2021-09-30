package com.kaganarmagan.hititinterviewassignment.controller;

import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.dto.CustomerRequestDTO;
import com.kaganarmagan.hititinterviewassignment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/index")
    public String findCustomers(Model model){
        model.addAttribute("customers",customerService.findAll()).addAttribute("cities",customerService.findCities());
        return "index";
    }


    @GetMapping("/register")
    public String addCustomer(Model model){
        model.addAttribute("customer",new CustomerRequestDTO());
        return "add-customer";
    }

    @PostMapping("/addcustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") @DateTimeFormat(pattern = "dd/MM/yyyy") CustomerRequestDTO customer ,BindingResult result){
        if(result.hasErrors()){
            return "add-customer";
        }
        customerService.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable long id,Model model){
        model.addAttribute("customer",customerService.findById(id));

        return "update-customer";
    }



    @PostMapping("/update")
    public String updateUser( @Valid @ModelAttribute("customer") CustomerListDTO customerListDTO, BindingResult result){
        if(result.hasErrors()){
            return "update-customer";
        }

        customerService.update(customerListDTO);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable long id){
        customerService.deleteById(id);
        return "redirect:/index";
    }



}
