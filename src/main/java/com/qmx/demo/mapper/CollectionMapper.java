package com.qmx.demo.mapper;

import com.qmx.demo.entity.Collection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Comment;
import com.qmx.demo.entity.Posting;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
public interface CollectionMapper extends BaseMapper<Collection> {

    //根据文章获取用户
    @Select("select userid from collection where postingid=#{postingid}")
    List<Integer> getCollectionUserByPostingid(Integer postingid);
    @Select("select count(*) from collection where postingid=#{postingid}")
    Integer getCollectionnumByPostingid(Integer postingid);

    //根据用户获取文章 //报废
    @Select("select * from collection where userid=#{id}")
    @Results({
            @Result(column="postingid",property = "postingset",
                    one=@One(
                            select="com.qmx.demo.mapper.PostingMapper.selectByPositngId"
                            //fetchType= FetchType.EAGER
                    )
            ),
    })
    List<Posting> getCollectionByUserid(Integer id);
    @Select("select count(*) from collection where userid=#{id}")
    Integer getCollectionnumByUserid(Integer id);
}
