package com.example.gest_stock.Controllers;

import com.example.gest_stock.Models.Article;
import com.example.gest_stock.Models.Categorie;
import com.example.gest_stock.Services.CatgService;
import com.example.gest_stock.Services.GoogleAnalyticsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatgController {
    private CatgService catgService;
    private GoogleAnalyticsService analyticsTagService;

    public CatgController(CatgService catgservice, GoogleAnalyticsService analyticsTagService) {
        this.catgService = catgservice;
        this.analyticsTagService = analyticsTagService;
    }

    @RequestMapping("/")
    public String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "redirect:/Categories";
        // if it is not authenticated, then go to the index...
        // other things ...
        return "redirect:/login";
    }

    @ModelAttribute("username")  // Add username to model for all controller methods
    public String getAuthenticatedUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? authentication.getName() : null;
    }

    @GetMapping("/Categories")
    public String getProducts(Model model)
    {
        // Proceed with your existing logic to retrieve categories
        List<Categorie> catg = catgService.listAll();
        model.addAttribute("listcatg", catg);
        return "index";
    }

    @GetMapping("/Categories/{id}/articles")
    public String getArticlesByCategories(@PathVariable("id") int id, Model model) {

//        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("username", userId);

        List<Article> artofcatg = catgService.getArticlesByCategories(id);
        model.addAttribute("listArticleOfCatg", artofcatg);
        model.addAttribute("categories", catgService.get(id)); // Fetch categories from service
        return "ByCategories";
    }

    @GetMapping("/Categories/add")
    public String showform(Model m) {
        m.addAttribute("c", new Categorie());
        return "AddForm";
    }

    @PostMapping("/Categories/add")
    public String save(@ModelAttribute("c") Categorie catg) {
        catgService.save(catg);
        return "redirect:/Categories";
    }

    @RequestMapping("/Categories/edit/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        Categorie categorie = catgService.get(id);
        model.addAttribute("data", categorie);
        return "editForm";
    }

    @PostMapping("/Categories/update/{id}")
    public String update(@ModelAttribute("data") Categorie categorie) {
        catgService.save(categorie);
        return "redirect:/Categories";
    }

    @RequestMapping("/Categories/delete/{id}")
    public String delete(@PathVariable int id) {
        catgService.delete(id);
        return "redirect:/Categories";
    }
}
