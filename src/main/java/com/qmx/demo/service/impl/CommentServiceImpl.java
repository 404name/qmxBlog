package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Comment;
import com.qmx.demo.mapper.CommentMapper;
import com.qmx.demo.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByPostingid(Integer postingid) {
        return commentMapper.getCommentByPostingid(postingid);
    }

    @Override
    public int getCommentnumByPostingid(Integer postingid) {
        return commentMapper.getCommentnumByPostingid(postingid);
    }
}
