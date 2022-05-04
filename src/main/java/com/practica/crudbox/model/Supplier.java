package com.practica.crudbox.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "suppliers")
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsupplier")
    private Long idSupplier;

    private String name;

    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set <Item> items;


}
