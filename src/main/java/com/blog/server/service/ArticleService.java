package com.blog.server.service;

import com.blog.server.domain.article.dto.ArticleCreationDTO;
import com.common.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
public interface ArticleService extends IService<Article> {

    void addArticle(ArticleCreationDTO dto);
}
