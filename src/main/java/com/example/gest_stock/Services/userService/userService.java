package com.example.gest_stock.Services.userService;
import com.example.gest_stock.Models.User;
import com.example.gest_stock.Repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userService  implements IUserService , UserDetailsService {

     private UserRepo userRepo;


     public userService (UserRepo userRepo){
         this.userRepo = userRepo;
     }

     public User Auth(String username,String password)
     {
        return userRepo.getUser(username,password);
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username).get();

    }
}
