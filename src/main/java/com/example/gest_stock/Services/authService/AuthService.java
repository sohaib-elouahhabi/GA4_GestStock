package com.example.gest_stock.Services.authService;

import com.example.gest_stock.Models.User;
import com.example.gest_stock.Services.userService.userService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final AuthenticationManager authenticationManager;
    private final userService  userservice;

    public AuthService(AuthenticationManager authenticationManager,userService  userservice) {
        this.authenticationManager = authenticationManager;
        this.userservice = userservice;
    }

    public  void login(User loginUser) {

        Authentication authUser = new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                loginUser.getPassword());
        try {
            this.authenticationManager.authenticate(authUser);
        } catch (Exception e) {
            // If authentication fails, throw an exception or handle it accordingly
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }
//    public void authenticateUser(User user){
//        SecurityContextHolder
//                .getContext()
//                .setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
//    }


}
