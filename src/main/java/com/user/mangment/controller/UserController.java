package com.user.mangment.controller;

import com.user.mangment.entities.User;
import com.user.mangment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = {"http://192.168.137.1:3000", "http://localhost:3000"})
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    @RolesAllowed("ADMIN")
    public String userTest() {
        return "Hello User..";
    }

    @PostMapping("/create")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/admin")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/tester")
    public String tester() {
        return "hello tester";
    }

    @GetMapping("/customer")
    public String customer() {
        return "hello customer";
    }

    @GetMapping("/allusers")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
