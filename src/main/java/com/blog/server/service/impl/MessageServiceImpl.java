package com.blog.server.service.impl;

import com.blog.common.entity.Message;
import com.blog.server.mapper.MessageMapper;
import com.blog.server.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
