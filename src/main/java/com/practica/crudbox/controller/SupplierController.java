package com.practica.crudbox.controller;

import com.practica.crudbox.exception.SupplierNotFoundException;
import com.practica.crudbox.model.Supplier;
import com.practica.crudbox.repository.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @GetMapping("/suppliers")
    public List<Supplier> all() {

        return supplierRepository.findAll();

    }

    @PostMapping("/suppliers")
    public Supplier newSupplier(@RequestBody Supplier newSupplier){

        return supplierRepository.save(newSupplier);

    }

    @GetMapping("/suppliers/{id}")
    public Supplier singleItem(@PathVariable Long id){

        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));

    }

    @PutMapping("/suppliers/{id}")
    public Supplier updateUser (@RequestBody Supplier newSupplier, @PathVariable Long id){

        return supplierRepository.findById(id).map(supplier -> {
            supplier.setName(newSupplier.getName());

            return supplierRepository.save(supplier);
        }).orElseGet(() -> {
            newSupplier.setIdSupplier(id);
            return supplierRepository.save(newSupplier);
        });
    }
    @DeleteMapping("/suppliers/{id}")
    public void deleteEmployee(@PathVariable Long id){

        supplierRepository.deleteById(id);

    }
}
