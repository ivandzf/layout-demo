package com.greenlabs.layoutdemo.core.dao;

import java.util.List;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
public interface BaseDAO<T> {

    T save(T entity);

    T update(T entity);

    T delete(T entity);

    T findById(Long id);

    List<T> find(T entity, Integer offset, Integer limit);

}
