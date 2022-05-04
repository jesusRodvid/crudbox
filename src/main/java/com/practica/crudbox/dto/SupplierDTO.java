package com.practica.crudbox.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practica.crudbox.model.Item;
import lombok.Data;

import java.util.Set;
@Data
public class SupplierDTO {

    private Long idSupplier;

    private String name;

    private String country;




}
