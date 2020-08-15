package com.qmx.demo.mapper;

import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commenttocomment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 404name
 * @since 2020-08-13
 */
@Repository
public interface CommenttocommentMapper extends BaseMapper<Commenttocomment> {
    @Select("select * from commenttocomment where tocommentid=#{commentid}")
    List<Commenttocomment> getCommentBycommentid(Integer commentid);
    @Select("select count(*) from commenttocomment where tocommentid=#{commentid}")
    Integer getCommentnumBycommentid(Integer commentid);
}
