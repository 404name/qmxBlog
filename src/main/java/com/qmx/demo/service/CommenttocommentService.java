package com.qmx.demo.service;

import com.qmx.demo.entity.Commenttocomment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
public interface CommenttocommentService extends IService<Commenttocomment> {
    List<Commenttocomment> getCommentBycommentid(Integer commentid);
    Integer getCommentnumBycommentid(Integer commentid);
}
