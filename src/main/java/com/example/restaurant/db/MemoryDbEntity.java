package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

//database가 공통적으로 사용하는 entity
public class MemoryDbEntity {

    protected Integer index;


}