package com.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.server.domain.convert.ArticleConvertMapper;
import com.blog.server.domain.article.dto.ArticleCreationDTO;
import com.blog.server.mapper.ArticleMapper;
import com.blog.server.service.ArticleService;
import com.common.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(ArticleCreationDTO dto) {
        LambdaQueryWrapper<Article> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Article::getTitle, dto.getTitle());
        if (articleMapper.selectList(queryWrapper).size() > 0) {
            throw new IllegalStateException("文章标题重复，请重新填写");
        }

        Article article = ArticleConvertMapper.convertDTO(dto);
        article.setDeleted(true);
        articleMapper.insert(article);
    }
}
