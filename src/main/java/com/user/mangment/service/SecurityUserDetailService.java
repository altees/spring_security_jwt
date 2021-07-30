package com.user.mangment.service;

import com.user.mangment.entities.Role;
import com.user.mangment.entities.User;
import com.user.mangment.repositories.UserRepository;
import com.user.mangment.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SecurityUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    //creating spring security UserDetails for authentication
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("load user by userName", userName);
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (!optionalUser.isPresent())
            throw new UsernameNotFoundException("user not found with username " + userName);
        User user = optionalUser.get();
        log.info("user found ", user);
        List<String> roleName = UserUtil.getRoleName(user);
        UserDetails userDetails = org.springframework.security.core.userdetails.User.
                builder().
                username(user.getUserName()).
                disabled(!user.isEnabled()).
                authorities(getUserAuthority(user.getRoles())).
                password(user.getPassword()).
                build();
        return userDetails;
    }


    private List<GrantedAuthority> getUserAuthority(List<Role> userRoles) {
        List<GrantedAuthority> grantedAuthorities = userRoles.
                stream().
                map(value -> new SimpleGrantedAuthority(value.getRoleName())).
                collect(Collectors.toList());
        return grantedAuthorities;
    }
}
