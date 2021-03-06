package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Postingclass;
import com.qmx.demo.mapper.PostingclassMapper;
import com.qmx.demo.service.PostingclassService;
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
public class PostingclassServiceImpl extends ServiceImpl<PostingclassMapper, Postingclass> implements PostingclassService {
    @Autowired
    private PostingclassMapper postingclassMapper;
    @Override
    public List<Postingclass> selectAll() {
        return postingclassMapper.selectAll();
    }
}
