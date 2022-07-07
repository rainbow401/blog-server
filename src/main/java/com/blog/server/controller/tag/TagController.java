package com.blog.server.controller.tag;


import com.blog.server.entity.Tag;
import com.blog.server.service.TagService;
import com.common.resopnse.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yanzhihao
 * @since 2022-07-06
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<List<Tag>> list() {
        return ResponseResult.success(tagService.list());
    }
}
