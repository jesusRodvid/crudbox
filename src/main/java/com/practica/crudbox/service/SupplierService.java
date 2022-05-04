package com.practica.crudbox.service;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    SupplierDTO createSupplier (SupplierDTO supplierDTO);

    List<SupplierDTO> getAllSuppliers();

    SupplierDTO getSupplierById(Long id);

    SupplierDTO updateSupplier (SupplierDTO supplierDTO, long id);

    void deleteSupplierById(long id);
}
