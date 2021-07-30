package com.user.mangment.controller;

import com.user.mangment.entities.Role;
import com.user.mangment.entities.User;
import com.user.mangment.service.RoleService;
import com.user.mangment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
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
}
