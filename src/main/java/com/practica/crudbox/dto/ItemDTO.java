package com.practica.crudbox.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practica.crudbox.model.Discount;
import com.practica.crudbox.model.EnumState;
import com.practica.crudbox.model.Supplier;
import com.practica.crudbox.model.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
@Data
public class ItemDTO {

    private Long idItem;
    private String description;
    private BigDecimal price ;
    private EnumState state;
    private Set<DiscountDTO> discounts;
    private Set <SupplierDTO> suppliers;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate creationDate;
    private UserDTO creator;
}
