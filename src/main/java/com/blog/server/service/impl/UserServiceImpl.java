package com.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.server.domain.auth.dto.LoginDTO;
import com.blog.server.domain.auth.util.TokenStore;
import com.blog.server.domain.user.dto.UserDTO;
import com.blog.server.mapper.UserMapper;
import com.blog.server.service.UserService;
import com.common.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@AllArgsConstructor(onConstructor_ = {@Resource})
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final TokenStore tokenStore;

    private final UserMapper userMapper;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public String login(LoginDTO dto) {

        String querySql = "select * from user where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<>(User.class), dto.getUsername(), dto.getPassword());
        if(user == null) {
            throw new IllegalArgumentException("not find user");
        }

        verifyPassword(dto, user);

        return tokenStore.generateToken(user);
    }

    @Override
    public Long create(UserDTO dto) {
        return null;
    }

    private void verifyPassword(LoginDTO dto, User user) {
        // todo 密码验证
    }
}