package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Luck;
import com.qmx.demo.mapper.LuckMapper;
import com.qmx.demo.service.LuckService;
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
 * @since 2020-09-16
 */
@Service
public class LuckServiceImpl extends ServiceImpl<LuckMapper, Luck> implements LuckService {
    @Autowired
    LuckMapper luckMapper;
    @Override
    public List<Luck> get2020Student(){
        return luckMapper.get2020Student();
    }
}
