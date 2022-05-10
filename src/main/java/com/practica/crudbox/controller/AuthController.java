package com.practica.crudbox.controller;

import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.model.User;
import com.practica.crudbox.payload.JWTAuthResponse;
import com.practica.crudbox.payload.LoginDTO;
import com.practica.crudbox.payload.SignUpDto;
import com.practica.crudbox.repository.UserRepository;
import com.practica.crudbox.security.JwtTokenProvider;
import com.practica.crudbox.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    private ResponseEntity <JWTAuthResponse> aunthenticateUser (@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

    @PostMapping("/signup")
    private ResponseEntity <?> registerUser (@RequestBody SignUpDto signUpDto){

       if(userService.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }
        User user = new User();

        user.setUsername(signUpDto.getUsername());
        user.setPassword(signUpDto.getPassword());

        userService.save(user);

        return new ResponseEntity<>("User registered!!", HttpStatus.OK);
    }


}
