package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Follow;
import com.qmx.demo.mapper.FollowMapper;
import com.qmx.demo.service.FollowService;
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
 * @since 2020-08-17
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
    @Autowired
    public FollowMapper followMapper;
    @Override
    public List<Integer> getFollowUserByid(Integer id) {
        return followMapper.getFollowUserByid(id);
    }

    @Override
    public Integer getFollowNumByid(Integer id) {
        return followMapper.getFollowNumByid(id);
    }

    @Override
    public List<Integer> getBeFollowUserByid(Integer id) {
        return followMapper.getBeFollowUserByid(id);
    }

    @Override
    public Integer getBeFollowNumByid(Integer id) {
        return followMapper.getBeFollowNumByid(id);
    }

    @Override
    public List<String> getFollowUserNameByid(Integer id) {
        return followMapper.getFollowUserNameByid(id);
    }

    @Override
    public List<String> getBeFollowUserNameByid(Integer id) {
        return followMapper.getBeFollowUserNameByid(id);
    }
}
