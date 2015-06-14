package de.crowdcode.vehicle.dao;

import java.util.List;

public interface EntityDao<T> {
    
    List<T> findAll();
    
    T find(Long id);
    
    void create(T entity);
    
    void delete(T entity);
    
    T update(T entity);

}
