package com.qmx.demo.mapper;

import com.qmx.demo.entity.Commentlike;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
public interface CommentlikeMapper extends BaseMapper<Commentlike> {
    //根据文章获取用户
    @Select("select userid from commentlike where commentid=#{commentid}")
    List<Integer> getCommentLikeUserByCommentid(Integer commentid);
    @Select("select count(*) from commentlike where commentid=#{commentid}")
    Integer getCommentLikenumByCommentid(Integer commentid);
}
