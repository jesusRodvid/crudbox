package com.practica.crudbox.controller;


import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/items")
public class ItemController {


    private ItemService itemService;

    public ItemController(ItemService itemRepository) {
        this.itemService = itemRepository;
    }


    @PostMapping("/createItems")
    public ResponseEntity<ItemDTO> createItems (@RequestBody ItemDTO itemDTO){

        return new ResponseEntity<>(itemService.createItem(itemDTO), HttpStatus.CREATED);

    }

    @GetMapping("/getAllItems")
    public List <ItemDTO>getAllItems(){

        return itemService.getAllItems();
    }

    @GetMapping("/getItemsById/{id}")
    public ResponseEntity <ItemDTO> getItemsById(@PathVariable(name = "id") long id){


        return  ResponseEntity.ok(itemService.getItemsById(id));
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity <ItemDTO> updateItem (@RequestBody ItemDTO itemDTO, @PathVariable(name = "id") long id){

        ItemDTO itemResponse = itemService.updateItems(itemDTO, id);
        return  new ResponseEntity<>(itemResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity <String> deleteItem(@PathVariable  (name = "id") long id){

        itemService.deleteItemById(id);

        return new ResponseEntity<>("Item entity deleted successfully." , HttpStatus.OK);

    }

}
