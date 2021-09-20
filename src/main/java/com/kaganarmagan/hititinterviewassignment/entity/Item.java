package com.kaganarmagan.hititinterviewassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends AbstractBaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double volume;
    @Column(nullable = false)
    private Double price;
    @Column(name = "city",nullable = false)
    private String destinationCity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}