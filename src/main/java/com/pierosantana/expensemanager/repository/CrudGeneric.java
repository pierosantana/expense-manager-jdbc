package com.pierosantana.expensemanager.repository;

import java.util.List;

public interface CrudGeneric <T>{
    T create(T entity);
    List<T> findAll();
    T findById(Long id);
    T update(Long id, T entity);
    void delete(Long id);
}
