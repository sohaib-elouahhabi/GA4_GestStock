package com.example.gest_stock.Controllers;

import com.example.gest_stock.Models.Article;
import com.example.gest_stock.Models.Categorie;
import com.example.gest_stock.Repositories.ArticleRepo;
import com.example.gest_stock.Services.ArticleService;
import com.example.gest_stock.Services.CatgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
//    public ArticleController(ArticleService articleService) {
//        this.articleService = articleService;
//    }
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private CatgService catgService;

    @ModelAttribute("username")  // Add username to model for all controller methods
    public String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? authentication.getName() : null;
    }

    @GetMapping("/Articles")
    public String getArticles(Model model,
        @RequestParam(name = "page",defaultValue = "0") int page,
        @RequestParam(name = "size",defaultValue = "3") int size )
    {
//        articleService.save(new Article(0,"Hp",6000));
        Page<Article> pagearticle = articleRepo.findAll(PageRequest.of(page,size));
        model.addAttribute("listarticle", pagearticle);
        model.addAttribute("categories", catgService.listAll());
        return "afiicherArticles";
    }

    @GetMapping("/Article/add" )
    public String showform(Model m){
        m.addAttribute("artc", new Article());
        m.addAttribute("categories", catgService.listAll()); // Fetch categories from service
        return "AddArticle";
    }

    @PostMapping("/Article/add")
    public String save(@ModelAttribute("artc") Article article){
        articleService.save(article);
        return "redirect:/Articles";
    }
    @RequestMapping("/Article/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Article article = articleService.get(id);
        model.addAttribute("data", article);
        return "editArticle";
    }

    @PostMapping( "/Article/update/{id}")
    public  String update(@ModelAttribute("data") Article article){
        articleService.save(article);
        return "redirect:/Articles";
    }

    @RequestMapping("/Article/delete/{id}")
    public String delete(@PathVariable int id){
        articleService.delete(id);
        return "redirect:/Articles";
    }
}