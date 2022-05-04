package com.practica.crudbox.repository;

import com.practica.crudbox.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Long> {
}
