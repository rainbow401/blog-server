package com.blog.server.service.impl;

import com.blog.server.entity.Tag;
import com.blog.server.mapper.TagMapper;
import com.blog.server.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
