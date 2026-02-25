package com.example.demo.Service;

import com.example.demo.Model.Item;

import java.math.BigInteger;
import java.util.List;

public interface ItemService {
    public Item findById(Long id);
    public List<Item> getAll();
    public Item save(Item item);
    public Item update(Long id, Item item);
    public void delete(Long id);
}
