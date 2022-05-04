package com.practica.crudbox.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "iddiscount")
    private Long idDiscount;
    @Column(name = "discountedprice")
    private BigDecimal discountedPrice;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "startdate")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "enddate")
    private LocalDate endDate;



}
