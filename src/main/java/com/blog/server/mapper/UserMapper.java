package com.blog.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
