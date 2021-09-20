package com.kaganarmagan.hititinterviewassignment.service;

import java.util.List;

public interface IBaseService<T,S,U> {

     T save(S object);
     List<U> findAll();
     String deleteById(Long id);
}
