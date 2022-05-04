package com.practica.crudbox.controller;

import com.practica.crudbox.dto.DiscountDTO;
import com.practica.crudbox.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    private DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }
    @PostMapping
    public ResponseEntity <DiscountDTO> createDiscount (@RequestBody DiscountDTO discountDTO){


        return new ResponseEntity<>(discountService.createDiscount(discountDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public List<DiscountDTO> getAllDiscounts(){

        return discountService.getAllDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity <DiscountDTO> getDiscountById(@PathVariable(name = "id") long id){

        return ResponseEntity.ok(discountService.getDiscountById(id));

    }
    @PutMapping("/{id}")
    public ResponseEntity <DiscountDTO> updateDiscounts (@RequestBody DiscountDTO discountDTO, @PathVariable long id){
        DiscountDTO discountResponse = discountService.updateDiscounts(discountDTO, id);
        return new ResponseEntity<>(discountResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity <String> deleteDiscountById(@PathVariable (name = "id") long id){

        discountService.deleteDiscountById(id);

        return new ResponseEntity<>("Discount deleted succesfully.", HttpStatus.OK);
    }
}
