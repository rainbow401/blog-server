package com.blog.server.component.context;

import com.blog.common.entity.User;

/**
 * @author yanzhihao
 * @date 2023/1/10
 * @Description
 */
public interface ServiceContext extends ServiceContextInternal {

    /**
     * userid
     * @return userid
     */
    String currentUserid();

    /**
     * userinfo
     * @return userinfo
     */
    User currentUserInfo();
}
