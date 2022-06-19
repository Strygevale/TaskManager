package com.example.taskmanager.service;

import com.example.taskmanager.model.Item;
import com.example.taskmanager.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Integer id){
        return itemRepository.getOne(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    public List<Item> listAll(Boolean keyword) {
        if (keyword != null) {
            return itemRepository.search(keyword);
        }
        return itemRepository.findAll();
    }
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Integer id){
        itemRepository.deleteById(id);
    }


}
