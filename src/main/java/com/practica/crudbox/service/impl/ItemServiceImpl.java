package com.practica.crudbox.service.impl;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.exception.ResourceNotFoundException;
import com.practica.crudbox.model.Item;
import com.practica.crudbox.repository.ItemRepository;
import com.practica.crudbox.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ModelMapper mapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        //conversion DTO to entity
        Item item = mapToEntity(itemDTO);
        Item newItem = itemRepository.save(item);

        //consersion ENTITY to DTO
        ItemDTO itemResponse = mapToDTO(newItem);
        return itemResponse;
    }

    @Override
    public List<ItemDTO> getAllItems() {

        List<Item> itemList = itemRepository.findAll();

        return itemList.stream().map(item -> mapToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemsById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return mapToDTO(item);
    }

    @Override
    public ItemDTO updateItems(ItemDTO itemDTO, long id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("User", "id", id));

        item.setDescription(itemDTO.getDescription());

        item.setPrice(itemDTO.getPrice());

        item.setState(itemDTO.getState());
        item.setDiscounts(mapToEntity(itemDTO).getDiscounts());

        item.setSuppliers(mapToEntity(itemDTO).getSuppliers());
        item.setCreationDate(itemDTO.getCreationDate());

        Item updatedItem = itemRepository.save(item);

        return mapToDTO(updatedItem);
    }

    @Override
    public void deleteItemById(long id) {

        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        itemRepository.delete(item);

    }

    private ItemDTO mapToDTO(Item item) {
        this.mapper.getConfiguration().setPreferNestedProperties(false);

        ItemDTO itemDTO = mapper.map (item, ItemDTO.class);

        return itemDTO;
    }

    private Item mapToEntity(ItemDTO itemDTO) {
        this.mapper.getConfiguration().setPreferNestedProperties(false);

        Item item = mapper.map (itemDTO, Item.class);

        return item;
    }


}
