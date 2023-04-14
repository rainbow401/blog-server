package com.blog.server.component.context.impl;

import com.blog.common.entity.User;
import com.blog.server.component.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yanzhihao
 * @Date 2023/1/10
 * @Description
 */
@Component
public class ServiceContextImpl implements ServiceContext {

    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<User> USER_INFO = new ThreadLocal<>();


    @Override
    public String currentUserid() {
        return USER_ID.get();
    }

    @Override
    public User currentUserInfo() {
        return USER_INFO.get();
    }

    @Override
    public void clear() {
        USER_ID.remove();
        USER_INFO.remove();
    }

    @Override
    public void extract(HttpServletRequest request) {

    }

    private void setUserInfo(User user) {
        USER_INFO.set(user);
        USER_ID.set(user.getUsername());
    }
}
