package com.blog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.common.entity.User;
import com.blog.server.domain.auth.dto.LoginDTO;
import com.blog.server.domain.user.dto.UserDTO;


public interface UserService extends IService<User> {

    String login(LoginDTO dto);

    void create(UserDTO dto);
}
