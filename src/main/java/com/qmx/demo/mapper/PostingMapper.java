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
                            select="com.qmx.demo.mapper.CommentMapper.selectAllByPostingid",
                            fetchType= FetchType.EAGER
                    )
            ),
            @Result(column="postingid",property="commentnum",
                    one=@One(
                            select="com.qmx.demo.mapper.CommentMapper.getCommentnumByPostingid"
                    )
            ),
            @Result(column="postingid",property="collectionnum",
                    one=@One(
                            select="com.qmx.demo.mapper.CollectionMapper.getCollectionnumByPostingid"
                    )
            ),
            @Result(column="postingid",property="collectionuserid",
                    many=@Many(
                            select="com.qmx.demo.mapper.CollectionMapper.getCollectionUserByPostingid",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    Posting selectByPositngId(Integer postingid);

    @Select("select * from posting")
    @Results({
            @Result(id=true,column="postingid",property="postingid"),
            @Result(column="username",property="username"),
            //@Result(column="postingid",property="collectionuserid",
            //        many=@Many(
            //                select="com.qmx.demo.mapper.CollectionMapper.getCollectionUserByPostingid",
            //                fetchType= FetchType.EAGER
            //        )
            //)
    })
    List<Posting> selectAll();

    @Select("select count(*) from posting where postingclass=#{postingclass}")
    Integer getPostingclassNum(Integer postingclass);

    @Select("select count(*) from posting")
    Integer getPostingNum();

    //用户查文章
    @Select("select count(*) from posting where id=#{id}")
    Integer getUserPostingNum(Integer id);

    @Select("select * from posting where id = #{id}")
    @Results({
            @Result(id=true,column="postingid",property="postingid"),
            @Result(column="username",property="username"),

            //因为目前逻辑是后台检测所以先忽略
            //@Result(column="postingid",property="collectionuserid",
            //        many=@Many(
            //                select="com.qmx.demo.mapper.CollectionMapper.getCollectionUserByPostingid",
            //                fetchType= FetchType.EAGER
            //        )
            //)
    })
    List<Posting> selectByid(Integer id);

    //按照收藏时间
    @Select("select * from posting where postingid in(select postingid from collection where userid=#{id}) order by postingdate desc;")
    @Results({
            @Result(id=true,column="postingid",property="postingid"),
            @Result(column="username",property="username"),
            //@Result(column="postingid",property="collectionuserid",
            //        many=@Many(
            //                select="com.qmx.demo.mapper.CollectionMapper.getCollectionUserByPostingid",
            //                fetchType= FetchType.EAGER
            //        )
            //)
    })
    List<Posting> selectCollectionByUserid(Integer id);
}
