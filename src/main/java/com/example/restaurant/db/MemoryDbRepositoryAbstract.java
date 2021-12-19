package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
//memorydbentity를 상속받은 generic type 이 필요

    private final List<T> db = new ArrayList<>();   //arraylist db 생성
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {

        return db.stream().filter(it -> it.getIndex() == index).findFirst();
        //getindex는 memroydbentity의 index를 정의
    }

    @Override
    public T save(T entity) {

        var optionalEntity= db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            // db 에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;


        }else{
            // db 에 이미 데이터가 있는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;

        }
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listall() {
        return db;
    }
}