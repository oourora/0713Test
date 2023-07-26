package com.example.Test.article;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty(message = "제목입력은 필수입니다")
    public String subject;

    @NotEmpty(message = "내용입력은 필수입니다")
    public String content;
}


