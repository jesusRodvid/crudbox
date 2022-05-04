package com.practica.crudbox.controller;


import com.practica.crudbox.exception.ItemNotFoundException;
import com.practica.crudbox.model.Item;
import com.practica.crudbox.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {


    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<Item> listAll() {

        return itemRepository.findAll();

    }

    @PostMapping("/items")
    public Item newItem(@RequestBody Item newItem){

        return itemRepository.save(newItem);

    }

    @GetMapping("/items/{id}")
    public Item singleItem(@PathVariable Long id){

        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

    }

    @PutMapping("/items/{id}")
    public Item updateItems (@RequestBody Item newItem, @PathVariable Long id){

        return itemRepository.findById(id).map(item -> {
            item.setDescription(newItem.getDescription());
            item.setPrice(newItem.getPrice());
            item.setState(newItem.getState());
            item.setDiscounts(newItem.getDiscounts());
            item.setSuppliers(newItem.getSuppliers());
            item.setCreationDate(newItem.getCreationDate());
            item.setCreator(newItem.getCreator());
            return itemRepository.save(item);
        }).orElseGet(() -> {
            newItem.setIdItem(id);
            return itemRepository.save(newItem);
        });
    }
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id){

        itemRepository.deleteById(id);

    }

}
