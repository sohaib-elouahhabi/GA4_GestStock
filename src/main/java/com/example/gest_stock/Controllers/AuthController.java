package com.example.gest_stock.Controllers;
import com.example.gest_stock.Models.User;
import com.example.gest_stock.Services.authService.AuthService;;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @PostMapping("/login")
//    public String  login(@RequestBody User user) {
//        this.authService.login(user);
//        return "redirect:/Categories";
//    }
}
