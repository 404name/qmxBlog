package com.qmx.demo.mapper;

import com.qmx.demo.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Posting;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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

    //楼中楼获取
    @Select("select * from comment where commentid = #{commentid}")
    @Results({
            @Result(id=true,column="commentid",property="commentid"),
            @Result(column="commentid",property="commentset",
                    many=@Many(
                            select="com.qmx.demo.mapper.CommenttocommentMapper.getCommentByCommentid",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    Posting selectBycommentId(Integer commentid);

    @Select("select * from comment where postingid = #{postingid}")
    @Results({
            @Result(id=true,column="commentid",property="commentid"),
            @Result(column="commentid",property="commentnum",
                    one=@One(
                            select="com.qmx.demo.mapper.CommenttocommentMapper.getCommentnumByCommentid",
                            fetchType= FetchType.EAGER
                    )
            ),
    })
    List<Posting> selectAllByPostingid(Integer postingid);

    @Select("select * from comment where topostingid=#{postingid}")
    List<Comment> getCommentByPostingid(Integer postingid);
    @Select("select count(*) from comment where topostingid=#{postingid}")
    Integer getCommentnumByPostingid(Integer postingid);
}
