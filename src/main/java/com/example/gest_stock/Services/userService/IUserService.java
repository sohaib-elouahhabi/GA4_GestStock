package com.example.gest_stock.Services.userService;

import com.example.gest_stock.Models.User;

public interface IUserService {

    public User Auth(String username, String password);
}
