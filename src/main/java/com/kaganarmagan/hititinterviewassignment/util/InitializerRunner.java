package com.kaganarmagan.hititinterviewassignment.util;


import com.kaganarmagan.hititinterviewassignment.entity.Customer;
import com.kaganarmagan.hititinterviewassignment.entity.Item;
import com.kaganarmagan.hititinterviewassignment.repository.ICustomerRepository;
import com.kaganarmagan.hititinterviewassignment.repository.IItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;


@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {

    private final ICustomerRepository customerRepository;

    private final IItemRepository itemRepository;



    @Override
    public void run(String... args) throws Exception {
        customerRepository.deleteAll();
        itemRepository.deleteAll();


        Customer customer1= Customer.builder().trId(12345678901L).email("pla@cehold.er").birthDate(LocalDate.of(1990, Month.JANUARY,1)).name("Ali Veli").phone("5551234567").city("İzmir").build();
        Customer customer2= Customer.builder().trId(12345678902L).email("plac@ehold.er").birthDate(LocalDate.of(1985, Month.JANUARY,1)).name("Ayşe Fatma").phone("5552345678").city("Ankara").build();
        Customer customer3= Customer.builder().trId(12345678903L).email("pl@acehold.er").birthDate(LocalDate.of(1991, Month.JANUARY,1)).name("Ahmet Mehmet").phone("5554567890").city("İstanbul").build();

        Item item1= Item.builder().name("Placeholder").destinationCity("İstanbul").price(25.35).volume(10.5).customer(customer1).build();
        Item item2= Item.builder().name("Lorem").destinationCity("İstanbul").price(35.40).volume(5.62).customer(customer2).build();
        Item item3= Item.builder().name("Ipsum").destinationCity("Ankara").price(90.65).volume(16.25).customer(customer3).build();
        Item item4= Item.builder().name("Dolorsit").destinationCity("Ankara").price(43.85).volume(14.23).customer(customer3).build();


        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);



    }



}
