package com.example.gest_stock.Services;

import com.example.gest_stock.Models.Article;
import com.example.gest_stock.Repositories.ArticleRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService{
    private ArticleRepo articleRepo;
    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }
    public List<Article> listAll(){
        return articleRepo.findAll();
    }
    public void save(Article artc){
        articleRepo.save(artc);

    }

    public Article get(int id){
        return articleRepo.findById(id).get();
    }

    public void delete(int id){
        articleRepo.deleteById(id);
    }


}
