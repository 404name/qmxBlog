package com.qmx.demo.service;

import com.qmx.demo.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.mapper.CommentMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
public interface CommentService extends IService<Comment> {
    Posting selectBycommentId(Integer commentid);
    List<Posting> selectAllByPostingid(Integer postingid);
    List<Comment> getCommentByPostingid(Integer postingid);
    int getCommentnumByPostingid(Integer postingid);
}
