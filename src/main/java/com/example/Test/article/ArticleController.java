package com.example.Test.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String List(Model model){
        List<Article> articleList = this.articleService.getlist();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bingingResult) {
        this.articleService.create(articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list";

    }
    @GetMapping(value="/detail/{id}")
    public String articleDetail(Model model, @PathVariable("id") Integer id, ArticleForm articleForm) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    public String articleModify(ArticleForm articleForm){
        Article article = this.articleService.getArticle(id);
        ArticleForm.setSubject(article.getSubject());
        ArticleForm.setContent(article.getContent());
        return "article_form";
    }


}
