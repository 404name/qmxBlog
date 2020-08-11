package com.qmx.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.qmx.demo.entity.Posting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Postingclass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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
public interface PostingMapper extends BaseMapper<Posting> {
    @Select("select * from posting where postingid = #{postingid}")
    @Results({
            @Result(id=true,column="postingid",property="postingid"),
            @Result(column="username",property="username"),
            @Result(column="postingid",property="commentset",
                    many=@Many(
                            select="com.qmx.demo.mapper.CommentMapper.getCommentByPostingid",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    Posting selectByPositngId(Integer postingid);

    @Select("select * from posting")
    @Results({
            @Result(id=true,column="postingid",property="postingid"),
            @Result(column="username",property="username"),
            @Result(column="postingid",property="commentnum",
                    one=@One(
                            select="com.qmx.demo.mapper.CommentMapper.getCommentnumByPostingid",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<Posting> selectAll();
}
