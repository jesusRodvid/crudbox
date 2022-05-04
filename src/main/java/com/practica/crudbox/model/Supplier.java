package com.practica.crudbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idSupplier;

    private String name;

    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set <Item> items;


}
