package com.practica.crudbox.controller;


import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.exception.ItemNotFoundException;
import com.practica.crudbox.model.Item;
import com.practica.crudbox.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {


    private ItemService itemService;

    public ItemController(ItemService itemRepository) {
        this.itemService = itemRepository;
    }


    @PostMapping
    public ResponseEntity<ItemDTO> createItems (@RequestBody ItemDTO itemDTO){

        return new ResponseEntity<>(itemService.createItem(itemDTO), HttpStatus.CREATED);

    }

    @GetMapping
    public List <ItemDTO>getAllItems(){

        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity <ItemDTO> getUserById (@PathVariable(name = "id") long id){


        return  ResponseEntity.ok(itemService.getItemsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <ItemDTO> updateUser (@RequestBody ItemDTO itemDTO, @PathVariable(name = "id") long id){

        ItemDTO itemResponse = itemService.updateItems(itemDTO, id);
        return  new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteUser(@PathVariable  (name = "id") long id){

        itemService.deleteItemById(id);

        return new ResponseEntity<>("Item entity deleted successfully." , HttpStatus.OK);

    }

}
