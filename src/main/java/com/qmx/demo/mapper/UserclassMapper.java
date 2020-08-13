package com.qmx.demo.mapper;

import com.qmx.demo.entity.Posting;
import com.qmx.demo.entity.Userclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
 * @since 2020-08-07
 */
@Repository
@Primary
public interface UserclassMapper extends BaseMapper<Userclass> {
    @Select("select * from userclass")
    @Results({
            @Result(column="userclass",property="userclassnum",
                    one=@One(
                            select="com.qmx.demo.mapper.UserMapper.getUserclassNum",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<Userclass> selectAll();
}
