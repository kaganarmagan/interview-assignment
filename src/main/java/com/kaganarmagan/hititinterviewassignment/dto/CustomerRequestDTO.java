package com.kaganarmagan.hititinterviewassignment.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Data
public class CustomerRequestDTO {

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$",message = "Tr Id is not Valid")
    private String trId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message = "Phone Number mandotory")
    private String phone;
    private LocalDate birthDate;


}

