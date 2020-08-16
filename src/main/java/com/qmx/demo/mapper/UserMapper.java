package com.qmx.demo.mapper;

import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="id",property="mypostingnum",
                    one=@One(
                            select="com.qmx.demo.mapper.PostingMapper.getUserPostingNum"
                    )
            ),
            @Result(column="id",property="mypostingset",
                    many=@Many(
                            select="com.qmx.demo.mapper.PostingMapper.selectByid",
                            fetchType= FetchType.EAGER
                    )
            ),
            @Result(column="id",property="collectionnum",
                    one=@One(
                            select="com.qmx.demo.mapper.CollectionMapper.getCollectionnumByUserid"
                    )
            ),
            @Result(column="id",property="collectionset",
                    many = @Many(
                            select="com.qmx.demo.mapper.PostingMapper.selectCollectionByUserid",
                            fetchType= FetchType.EAGER
                    )
            ),
    })
    User selectById(Integer id);

    @Select("select count(*) from user where userclass=#{userclass}")
    Integer getUserclassNum(Integer userclass);
    @Select("select count(*) from user")
    Integer getUserNum();
}
