package com.practica.crudbox.service;

import com.practica.crudbox.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser (UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO updateUser (UserDTO userDTO, long id);

    UserDTO findUserByName (String userName);

    void deleteUserById(long id);
}
