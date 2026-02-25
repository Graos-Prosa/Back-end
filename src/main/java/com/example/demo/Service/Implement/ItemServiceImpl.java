package com.example.demo.Service.Implement;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Service.ItemService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado."));
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    //implementar metodo de update
    @Override
    public Item update(Long id, Item item) {
        return null;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
