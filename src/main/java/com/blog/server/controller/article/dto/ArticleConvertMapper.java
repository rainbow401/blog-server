package com.blog.server.controller.article.dto;

import com.blog.server.entity.Article;

public class ArticleConvertMapper {

    public static Article convertDTO(ArticleCreationDTO dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setTagId(dto.getTagId());
        return article;
    }
}
