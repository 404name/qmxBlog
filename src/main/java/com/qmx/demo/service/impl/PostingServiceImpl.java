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

    @Override
    public Integer getUserPostingNum(Integer id) {
        return postingMapper.getUserPostingNum(id);
    }

    @Override
    public List<Posting> selectByid(Integer id) {
        return postingMapper.selectByid(id);
    }

    @Override
    public List<Posting> selectCollectionByUserid(Integer id) {
        return postingMapper.selectCollectionByUserid(id);
    }

    @Override
    public Posting select1() {
        return postingMapper.select1();
    }

    @Override
    public Posting select2() {
        return postingMapper.select2();
    }

    @Override
    public Posting select3() {
        return postingMapper.select3();
    }

    @Override
    public Posting select4() {
        return postingMapper.select4();
    }
}
