package com.practica.crudbox.service;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.model.Item;

import java.util.List;

public interface ItemService {


    ItemDTO createItem (ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemDTO getItemsById(Long id);

    ItemDTO updateItems (ItemDTO itemDTO, long id);

    void deleteItemById(long id);



}
