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

    //根据用户获取文章
    @Select("select postingid from collection where userid=#{userid}")
    @Results({
            @Result(column="postingid",property = "Posting",
                    one=@One(
                            select="com.qmx.demo.mapper.PostingMapper.selectByPositngId"
                    )
            ),
    })
    List<Posting> getCollectionByUserid(Integer userid);
    @Select("select count(*) from collection where userid=#{userid}")
    Integer getCollectionnumByUserid(Integer userid);
}
