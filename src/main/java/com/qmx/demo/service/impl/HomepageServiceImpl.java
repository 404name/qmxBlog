package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Homepage;
import com.qmx.demo.mapper.HomepageMapper;
import com.qmx.demo.service.HomepageService;
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
 * @since 2020-08-24
 */
@Service
public class HomepageServiceImpl extends ServiceImpl<HomepageMapper, Homepage> implements HomepageService {
    @Autowired
    private HomepageMapper homepageMapper;
    @Override
    public List<Homepage> selectAll() {
        return homepageMapper.selectAll();
    }
}
