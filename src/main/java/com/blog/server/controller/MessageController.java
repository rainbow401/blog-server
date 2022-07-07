package com.blog.server.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.server.entity.Message;
import com.blog.server.service.MessageService;
import com.common.model.PageDTO;
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
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/page")
    public ResponseResult<Page<Message>> page(PageDTO dto) {
        return ResponseResult.success(messageService.page(new Page<>(dto.getPageNo(), dto.getPageSize())));
    }

    @GetMapping("/list")
    public ResponseResult<List<Message>> list() {
        return ResponseResult.success(messageService.list());
    }
}
