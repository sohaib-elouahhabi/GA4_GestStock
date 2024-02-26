package com.example.gest_stock.Repositories;

import com.example.gest_stock.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article,Integer> {


}
