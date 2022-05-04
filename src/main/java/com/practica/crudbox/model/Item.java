package com.practica.crudbox.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idItem;

    private String description;

    private BigDecimal price ;
    @Enumerated(EnumType.STRING)
    private EnumState state;

    @ManyToMany
    private Set <Discount> discounts;

    @ManyToMany
    @JoinTable(
            name = "items_suppliers",
            joinColumns =  @JoinColumn (name = "iditem"),
            inverseJoinColumns = @JoinColumn (name = "idsupplier")
    )
    private Set <Supplier> suppliers;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;


}
