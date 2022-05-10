package com.practica.crudbox.controller;

import com.practica.crudbox.dto.SupplierDTO;
import com.practica.crudbox.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/suppliers")
public class SupplierController {


   private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/createSupplier")
    public ResponseEntity<SupplierDTO> createSupplier (@RequestBody SupplierDTO supplierDTO){

        return new ResponseEntity<>(supplierService.createSupplier(supplierDTO), HttpStatus.CREATED);

    }

    @GetMapping("/getAllSuppliers")
    public List <SupplierDTO>getAllSuppliers(){

        return supplierService.getAllSuppliers();
    }

    @GetMapping("/getSupplierById/{id}")
    public ResponseEntity <SupplierDTO> getSupplierById(@PathVariable(name = "id") long id){


        return  ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity <SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable(name = "id") long id){

        SupplierDTO supplierResponse = supplierService.updateSupplier(supplierDTO, id);
        return  new ResponseEntity<>(supplierResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity <String> deleteSupplier(@PathVariable  (name = "id") long id){

        supplierService.deleteSupplierById(id);

        return new ResponseEntity<>("User entity deleted successfully." , HttpStatus.OK);

    }


}
