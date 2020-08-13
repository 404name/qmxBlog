package com.qmx.demo.mapper;

import com.qmx.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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
    @Select("select count(*) from user where userclass=#{userclass}")
    Integer getUserclassNum(Integer userclass);
    @Select("select count(*) from user")
    Integer getUserNum();
}
