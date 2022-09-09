package com.blog.server.mapper;

import com.blog.common.entity.ArticleComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
@Mapper
public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {

}
