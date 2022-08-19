package com.blog.server.domain.convert;

import com.blog.server.domain.article.dto.ArticleCreationDTO;
import com.common.entity.Article;

public class ArticleConvertMapper {

    public static Article convertDTO(ArticleCreationDTO dto) {
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setTagId(dto.getTagId());
        return article;
    }
}
