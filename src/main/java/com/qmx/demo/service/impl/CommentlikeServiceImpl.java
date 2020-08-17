package com.qmx.demo.service.impl;

import com.qmx.demo.entity.Commentlike;
import com.qmx.demo.mapper.CommentlikeMapper;
import com.qmx.demo.service.CommentlikeService;
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
public class CommentlikeServiceImpl extends ServiceImpl<CommentlikeMapper, Commentlike> implements CommentlikeService {
    @Autowired
    private CommentlikeMapper commentlikeMapper;
    @Override
    public List<Integer> getCommentLikeUserByCommentid(Integer commentid) {
        return commentlikeMapper.getCommentLikeUserByCommentid(commentid);
    }

    @Override
    public Integer getCommentLikenumByCommentid(Integer commentid) {
        return commentlikeMapper.getCommentLikenumByCommentid(commentid);
    }
}
