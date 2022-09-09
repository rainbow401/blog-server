package com.blog.server.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.common.dto.PageDTO;
import com.blog.common.entity.Article;
import com.blog.common.resopnse.ResponseResult;
import com.blog.server.domain.article.dto.ArticleCreationDTO;
import com.blog.server.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
@RequestMapping("/article")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 分页查询文章
     *
     * @param dto 分页参数
     * @return ResponseResult<Page < Article>>
     */
    @GetMapping("/page")
    public ResponseResult<Page<Article>> page(PageDTO dto) {
        return ResponseResult.success(articleService.page(new Page<>(dto.getPageNo(), dto.getPageSize())));
    }

    /**
     * 查询所有文章
     *
     * @return ResponseResult<List < Article>>
     */
    @GetMapping("/list")
    public ResponseResult<List<Article>> list() {
        return ResponseResult.success(articleService.list());
    }

    /**
     * 创建文章
     *
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseResult<Long> createArticle(@RequestBody ArticleCreationDTO dto) {
        articleService.addArticle(dto);
        return ResponseResult.success();
    }
}
