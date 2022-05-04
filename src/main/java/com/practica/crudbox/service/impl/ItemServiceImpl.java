package com.practica.crudbox.service.impl;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.model.Item;
import com.practica.crudbox.repository.ItemRepository;
import com.practica.crudbox.repository.SupplierRepository;
import com.practica.crudbox.repository.UserRepository;
import com.practica.crudbox.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemServiceImpl implements ItemService {


    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return null;
    }

    @Override
    public ItemDTO getItemsById(Long id) {
        return null;
    }

    @Override
    public ItemDTO updateItems(ItemDTO itemDTO, long id) {
        return null;
    }

    @Override
    public void deleteItemById(long id) {

    }
}
