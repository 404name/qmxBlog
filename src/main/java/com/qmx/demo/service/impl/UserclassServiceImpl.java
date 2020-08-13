package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Userclass;
import com.qmx.demo.mapper.UserclassMapper;
import com.qmx.demo.service.UserclassService;
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
 * @since 2020-08-07
 */
@Service
public class UserclassServiceImpl extends ServiceImpl<UserclassMapper, Userclass> implements UserclassService {
    @Autowired
    private  UserclassMapper userclassMapper;
    @Override
    public List<Userclass> selectAll() {
        return userclassMapper.selectAll();
    }
}
