package com.kaganarmagan.hititinterviewassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemListDTO {
    private Long id;
    private String name;
    private Double volume;
    private Double price;
    private String destinationCity;
    private Long customerId;

}
