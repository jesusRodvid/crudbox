package com.practica.crudbox.service.impl;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.dto.SupplierDTO;
import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.exception.ResourceNotFoundException;
import com.practica.crudbox.model.Item;
import com.practica.crudbox.model.Supplier;
import com.practica.crudbox.model.User;
import com.practica.crudbox.repository.ItemRepository;
import com.practica.crudbox.repository.SupplierRepository;
import com.practica.crudbox.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class SupplierServiceImpl implements SupplierService {

    private ModelMapper mapper;
    private SupplierRepository supplierRepository;
    private ItemRepository itemRepository;

    public SupplierServiceImpl(ModelMapper mapper, SupplierRepository supplierRepository, ItemRepository itemRepository) {
        this.mapper = mapper;
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = mapToEntity(supplierDTO);


        Supplier newSupplier = supplierRepository.save(supplier);
        SupplierDTO supplierResponse = mapToDTO(newSupplier);

        return supplierResponse;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {

        List<Supplier> supplierList = supplierRepository.findAll();

        return supplierList.stream().map(supplier -> mapToDTO(supplier)).collect(Collectors.toList());
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", id));

        return mapToDTO(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO, long id) {

        Supplier supplier = supplierRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("User", "id", id));
        supplier.setName(supplierDTO.getName());
        supplier.setCountry(supplierDTO.getCountry());

        Supplier updatedSupplier = supplierRepository.save(supplier);

        return mapToDTO(updatedSupplier) ;
    }

    @Override
    public void deleteSupplierById(long id) {

    }

    private SupplierDTO mapToDTO(Supplier supplier) {
        this.mapper.getConfiguration().setPreferNestedProperties(false);
        SupplierDTO supplierDTO = mapper.map (supplier, SupplierDTO.class);

        return supplierDTO;
    }

    private Supplier mapToEntity(SupplierDTO supplierDTO) {
        this.mapper.getConfiguration().setPreferNestedProperties(false);

        Supplier supplier = mapper.map (supplierDTO, Supplier.class);

        return supplier;
    }
}
