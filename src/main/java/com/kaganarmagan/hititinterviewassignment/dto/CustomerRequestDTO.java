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
    @Pattern(regexp = "^(?![\\s.]+$)[a-zA-Z\\s.]*$",message = "Only english alphabet,dot and space are allowed")
    private String name;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    private String email;
    @Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$",message = "Mobile phone is not valid")
    @NotBlank(message = "Phone Number mandotory")
    private String phone;
    private LocalDate birthDate;


}

