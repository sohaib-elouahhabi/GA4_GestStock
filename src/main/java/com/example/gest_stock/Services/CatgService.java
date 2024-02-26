package com.example.gest_stock.Services;


import com.example.gest_stock.Models.Article;
import com.example.gest_stock.Models.Categorie;
import com.example.gest_stock.Models.User;
import com.example.gest_stock.Repositories.CatgRepo;
import com.example.gest_stock.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatgService {
    @Autowired
    private CatgRepo catgRepo;

    @Autowired
    private UserRepo userRepo;
    public List<Categorie> listAll(){
        return catgRepo.findAll();
    }
    public void save(Categorie catg){
        catgRepo.save(catg);
    }

    public User Auth(String username, String password) {
        User users = userRepo.getUser(username, password);
        return users;
    }

    public Categorie get(int id){
        return catgRepo.findById(id).get();
    }

    public void delete(int id){
        catgRepo.deleteById(id);
    }

    public List<Article> getArticlesByCategories(int id) {
        return catgRepo.getArticlesByCategories(id);
    }
}
