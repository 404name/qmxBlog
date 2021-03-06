package com.qmx.demo.mapper;

import com.qmx.demo.entity.Follow;
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
 * @since 2020-08-17
 */
@Repository
public interface FollowMapper extends BaseMapper<Follow> {
    @Select("select followid from  follow where userid=#{id}")
    List<Integer> getFollowUserByid(Integer id);
    @Select("select followname from  follow where userid=#{id}")
    List<String> getFollowUserNameByid(Integer id);
    @Select("select count(*) from follow where userid=#{id}")
    Integer getFollowNumByid(Integer id);
    @Select("select userid from  follow where followid=#{id}")
    List<Integer> getBeFollowUserByid(Integer id);
    @Select("select username from  follow where followid=#{id}")
    List<String> getBeFollowUserNameByid(Integer id);
    @Select("select count(*) from follow where followid=#{id}")
    Integer getBeFollowNumByid(Integer id);
}
