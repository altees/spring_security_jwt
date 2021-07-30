package com.user.mangment.service;

import com.user.mangment.entities.Role;
import com.user.mangment.entities.User;
import com.user.mangment.repositories.RoleRepository;
import com.user.mangment.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    @Override
    public User saveUser(User user) {
        List<String> roleNames = getRoleName(user);
        List<Role> roles = roleRepository.findByRoleNameIn(roleNames);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    private List<String> getRoleName(User user) {
        List<String> roleNames = user.
                getRoles().
                stream().
                map(value -> value.getRoleName())
                .collect(Collectors.toList());
        return roleNames;
    }
}
