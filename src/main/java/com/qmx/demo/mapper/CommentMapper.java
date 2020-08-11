package com.qmx.demo.mapper;

import com.qmx.demo.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
@Repository
@Primary
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment where topostingid=#{postingid}")
    List<Comment> getCommentByPostingid(Integer postingid);
    @Select("select count(*) from comment where topostingid=#{postingid}")
    Integer getCommentnumByPostingid(Integer postingid);
}
