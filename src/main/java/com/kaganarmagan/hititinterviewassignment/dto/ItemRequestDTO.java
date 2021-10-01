package com.kaganarmagan.hititinterviewassignment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class ItemRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Pattern(regexp = "^(([1-9](\\d*|\\d{0,2}(,\\d{3})*))|0)(\\.\\d{1,2})?$",message = "Price is not Valid.")
    private String volume;
    @Pattern(regexp = "^(([1-9](\\d*|\\d{0,2}(,\\d{3})*))|0)(\\.\\d{1,2})?$",message = "Price is not Valid.")
    private String price;
    @NotBlank(message = "City is mandatory")
    private String destinationCity;

    private Long customerId;

    public ItemRequestDTO(long customerId){
        this.customerId=customerId;
    }



}
