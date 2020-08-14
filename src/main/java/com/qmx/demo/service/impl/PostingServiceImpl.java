package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Posting;
import com.qmx.demo.mapper.PostingMapper;
import com.qmx.demo.service.PostingService;
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
 * @since 2020-08-03
 */
@Service
public class PostingServiceImpl extends ServiceImpl<PostingMapper, Posting> implements PostingService {
    @Autowired
    private  PostingMapper postingMapper;
    @Override
    public Posting selectByPositngId(Integer postingid) {
        return postingMapper.selectByPositngId(postingid);
    }

    @Override
    public List<Posting> selectAll() {
        return postingMapper.selectAll();
    }

    @Override
    public Integer getPostingclassNum(Integer postingclass) {
        return postingMapper.getPostingclassNum(postingclass);
    }

//    @Override
//    public void increasePostingLikes(Integer postingclass) {
//        postingMapper.increasePostingLikes(postingid);
//    }


    @Override
    public Integer getPostingNum() {
        return postingMapper.getPostingNum();
    }
}
