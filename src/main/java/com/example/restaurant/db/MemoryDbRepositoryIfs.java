package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {   //generic type 설정
    Optional<T> findById(int index);    //해당된 index의 type을 return 하는 entity
    T save(T entity);                   //save
    void deleteById(int index);         //delete
    List<T> listall();                  //find all
}
