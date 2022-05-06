package com.practica.crudbox.service.impl;

import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.exception.ResourceNotFoundException;
import com.practica.crudbox.model.User;
import com.practica.crudbox.repository.UserRepository;
import com.practica.crudbox.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    private UserRepository userRepository;
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        //conversion DTO to entity
        User user = mapToEntity(userDTO);

        user.setUsername(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User newUser = userRepository.save(user);

        //consersion ENTITY to DTO
        UserDTO userResponse = mapToDTO(newUser);
        return userResponse;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> usersList = userRepository.findAll();

        return usersList.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());


    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {

        User user = userRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("User", "id", id));
        user.setUsername(userDTO.getUserName());

        User updatedUser = userRepository.save(user);

        return mapToDTO(updatedUser) ;
    }

    @Override
    public UserDTO findUserByName(String userName) {
        return mapToDTO(userRepository.findByUsername(userName).orElse(null));
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    private UserDTO mapToDTO(User user) {

        UserDTO userDTO = mapper.map (user, UserDTO.class);

        return userDTO;
    }

    private User mapToEntity(UserDTO userDTO) {

        User user = mapper.map (userDTO, User.class);

        return user;
    }



}