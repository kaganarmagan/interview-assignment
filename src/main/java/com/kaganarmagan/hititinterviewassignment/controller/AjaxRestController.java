package com.kaganarmagan.hititinterviewassignment.controller;

import com.kaganarmagan.hititinterviewassignment.ajax.AjaxRequestBody;
import com.kaganarmagan.hititinterviewassignment.ajax.AjaxResponseBody;
import com.kaganarmagan.hititinterviewassignment.dto.CustomerListDTO;
import com.kaganarmagan.hititinterviewassignment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AjaxRestController {
    private final CustomerService customerService;



    @PostMapping("/city")
    public ResponseEntity<AjaxResponseBody> getResultsByCity(@RequestBody AjaxRequestBody city){
        AjaxResponseBody result=new AjaxResponseBody();
        List<CustomerListDTO> list;
        if(city.getRequest().equals("All")){
            list =customerService.findAll();
        }else {
            list = customerService.findCustomersByCity(city.getRequest()) ;
        }
        if(list.isEmpty()){
            result.setMsg("error");
        }else{
            result.setMsg("ok");
        }

        result.setResult(list);
        return ResponseEntity.ok(result);
    }
}
