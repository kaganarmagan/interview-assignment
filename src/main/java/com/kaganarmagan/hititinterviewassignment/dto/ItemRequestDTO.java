package com.kaganarmagan.hititinterviewassignment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ItemRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @DecimalMin(value="0.0",message = "Value is not valid")
    private Double volume;
    @DecimalMin(value="0.0",message = "Value is not valid")
    @Digits(integer = 6, fraction = 2)
    private Double price;
    @NotBlank(message = "City is mandatory")
    private String destinationCity;

    private Long customerId;

    public ItemRequestDTO(long customerId){
        this.customerId=customerId;
    }



}
