package com.practica.crudbox.controller;

import com.practica.crudbox.dto.ItemDTO;
import com.practica.crudbox.dto.SupplierDTO;
import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.exception.SupplierNotFoundException;
import com.practica.crudbox.model.Supplier;
import com.practica.crudbox.repository.SupplierRepository;
import com.practica.crudbox.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {


   private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier (@RequestBody SupplierDTO supplierDTO){

        return new ResponseEntity<>(supplierService.createSupplier(supplierDTO), HttpStatus.CREATED);

    }

    @GetMapping
    public List <SupplierDTO>getAllSuppliers(){

        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity <SupplierDTO> getUserById (@PathVariable(name = "id") long id){


        return  ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <SupplierDTO> updateUser (@RequestBody SupplierDTO supplierDTO, @PathVariable(name = "id") long id){

        SupplierDTO supplierResponse = supplierService.updateSupplier(supplierDTO, id);
        return  new ResponseEntity<>(supplierResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteUser(@PathVariable  (name = "id") long id){

        supplierService.deleteSupplierById(id);

        return new ResponseEntity<>("User entity deleted successfully." , HttpStatus.OK);

    }


}
