package com.practica.crudbox.security;

import com.practica.crudbox.exception.UserNotFoundException;
import com.practica.crudbox.model.User;
import com.practica.crudbox.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsSurviveImpl implements UserDetailsService {


    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(name).orElseThrow(() -> new UserNotFoundException(name));

        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(new SimpleGrantedAuthority((user.getUsername())));

        return new org.springframework.security.core.userdetails.User(name, user.getPassword(), grantedAuthority);
    }


}
