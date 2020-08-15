package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Commenttocomment;
import com.qmx.demo.mapper.CommenttocommentMapper;
import com.qmx.demo.service.CommenttocommentService;
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
 * @since 2020-08-13
 */
@Service
public class CommenttocommentServiceImpl extends ServiceImpl<CommenttocommentMapper, Commenttocomment> implements CommenttocommentService {
    @Autowired
    public CommenttocommentMapper commenttocommentMapper;
    @Override
    public List<Commenttocomment> getCommentBycommentid(Integer commentid) {
        return commenttocommentMapper.getCommentBycommentid(commentid);
    }

    @Override
    public Integer getCommentnumBycommentid(Integer commentid) {
        return commenttocommentMapper.getCommentnumBycommentid(commentid);
    }
}
