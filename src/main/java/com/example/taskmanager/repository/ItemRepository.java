package com.example.taskmanager.repository;

import com.example.taskmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT * FROM items WHERE done != ?", nativeQuery = true)
    public List<Item> search(boolean keyword);
}
