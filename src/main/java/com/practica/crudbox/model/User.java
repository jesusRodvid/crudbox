package com.practica.crudbox.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column ( name = "IDUSER")
    private Long idUser;


    @Basic
    @Column
    private String name;

    public User() {
    }


}
