package com.blog.server.controller;

import com.blog.server.domain.user.dto.UserDTO;
import com.blog.server.service.UserService;
import com.common.resopnse.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor_ = {@Resource})
public class UserController {

    private final UserService userService;

    public ResponseResult<Long> create(UserDTO dto) {
        return ResponseResult.success(userService.create(dto));
    }
}
