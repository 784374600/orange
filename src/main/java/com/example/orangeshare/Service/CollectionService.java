package com.example.orangeshare.Service;

import com.example.orangeshare.Pojo.Collect;

import java.util.List;

public interface CollectionService {
    boolean add(Collect collect);
    boolean delete(Collect collect);
    List<Collect>  getCollections(String id);
}
