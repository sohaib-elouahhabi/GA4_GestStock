package com.example.gest_stock.Repositories;

import com.example.gest_stock.Models.Article;
import com.example.gest_stock.Models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CatgRepo extends JpaRepository<Categorie,Integer> {

//    @Query("SELECT Article FROM Categorie c where c.id = ?1")
//    List<Article> getArticlesByCategories(int id);

    @Query("SELECT a FROM Article a WHERE a.categorie.id = ?1")
    List<Article> getArticlesByCategories(int id);

}
