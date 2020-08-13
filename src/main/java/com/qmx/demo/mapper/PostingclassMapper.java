package com.qmx.demo.mapper;

import com.qmx.demo.entity.Postingclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Userclass;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
 * @since 2020-08-07
 */
@Repository
public interface PostingclassMapper extends BaseMapper<Postingclass> {
    @Select("select * from postingclass")
    @Results({
            @Result(column="postingclass",property="postingclassnum",
                    one=@One(
                            select="com.qmx.demo.mapper.PostingMapper.getPostingclassNum",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<Postingclass> selectAll();
}
