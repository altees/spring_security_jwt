package com.user.mangment.controller;

import com.user.mangment.request.JWTRequest;
import com.user.mangment.util.JWTUtil;
import com.user.mangment.vo.JWTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class JWTController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/generate")
    public ResponseEntity<?> generateToken(@RequestBody JWTRequest request) throws Exception {
        if (request.getPassword() == null || request.getUserName() == null)
            throw new Exception("username or password can not be null ");
        authenticate(request.getUserName(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }

    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new Exception("User desabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials");
        }
    }
}
