package com.kaganarmagan.hititinterviewassignment.dto;


import lombok.Data;

import java.time.LocalDate;


@Data
public class CustomerListDTO {
    private Long id;
    private Long trId;
    private String name;
    private String city;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private Integer items;
}
