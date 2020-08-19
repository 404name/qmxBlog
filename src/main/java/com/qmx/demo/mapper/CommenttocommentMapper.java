package com.qmx.demo.mapper;

import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Commenttocomment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
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
    @Select("select * from commenttocomment where tocommentid=#{commentid} order by commentid asc")
    @Results({
            @Result(column="userid",property="userid"),
            @Result(column="userid",property="followset",
                    many=@Many(
                            select="com.qmx.demo.mapper.FollowMapper.getFollowUserByid",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<Commenttocomment> getCommentBycommentid(Integer commentid);
    @Select("select count(*) from commenttocomment where tocommentid=#{commentid}")
    Integer getCommentnumBycommentid(Integer commentid);
}
