package com.practica.crudbox.controller;

import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.model.User;
import com.practica.crudbox.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController{



    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/crearuser")
    public ResponseEntity <UserDTO> createUser (@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);

    }

    @GetMapping
    public List <UserDTO>getAllUser(){

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDTO> getUserById (@PathVariable(name = "id") long id){


        return  ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserDTO> updateUser (@RequestBody UserDTO userDTO, @PathVariable(name = "id") long id){

        UserDTO userResponse = userService.updateUser(userDTO, id);
        return  new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteUser(@PathVariable  (name = "id") long id){

        userService.deleteUserById(id);

        return new ResponseEntity<>("User entity deleted successfully." , HttpStatus.OK);

    }



}
