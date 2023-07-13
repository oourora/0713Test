package com.example.Test.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getlist(){
        return this.articleRepository.findAll();
    }

    public void create(String subject, String content){
        Article a = new Article();
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        a.setSubject(subject);
        this.articleRepository.save(a);
    }

}
