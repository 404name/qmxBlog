package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Message;
import com.qmx.demo.mapper.MessageMapper;
import com.qmx.demo.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 404name
 * @since 2020-09-05
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Message> selectByUserid(Integer id) {
        return messageMapper.selectByUserid(id);
    }
}
