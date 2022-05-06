package com.practica.crudbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column ( name = "IDUSER")
    private Long idUser;

    @Basic
    @Column( name = "username")
    private String username;

    @Column
    private String password;

    public User() {
    }


}
