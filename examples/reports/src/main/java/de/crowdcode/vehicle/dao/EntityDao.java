package de.crowdcode.vehicle.dao;

import java.util.List;

public interface EntityDao<T> {
    
    public List<T> findAll();
    
    public T find(Long id);
    
    public void create(T entity);
    
    public void delete(T entity);
    
    public T update(T entity);

}
