package com.qmx.demo.service.impl;

import com.qmx.demo.entity.User;
import com.qmx.demo.mapper.UserMapper;
import com.qmx.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer getUserclassNum(Integer userclass) {
        return userMapper.getUserclassNum(userclass);
    }

    @Override
    public Integer getUserNum() {
        return userMapper.getUserNum();
    }
}
