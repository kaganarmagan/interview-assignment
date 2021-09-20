package com.kaganarmagan.hititinterviewassignment.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer extends AbstractBaseEntity{
    @DecimalMin(value="10000000000")
    @DecimalMax(value="99999999999")
    @Column(name="national_id_number",unique = true)
    private Long trId;

    @Column(name="full_name",nullable = false)
    private String name;


    @Column(nullable = false)
    private String  city;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Past
    @Column(nullable = false,name = "birth_date")
    private LocalDate birthDate;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Item> items=new ArrayList<>();
}
