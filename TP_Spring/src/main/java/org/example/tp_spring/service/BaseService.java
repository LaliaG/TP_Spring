package org.example.tp_spring.service;

import java.util.List;

public interface BaseService <TPost, TGet>{
    TGet create(TPost post);
    TGet update(int id, TPost post);
    boolean delete(int id);
    TGet findById(int id);
    List<TGet> findAll();
}
