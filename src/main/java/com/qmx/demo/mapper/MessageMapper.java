package com.qmx.demo.mapper;

import com.qmx.demo.entity.Homepage;
import com.qmx.demo.entity.Message;
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
 * @since 2020-09-05
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {
    @Select("select * from message where touserid=#{id}")
    List<Message> selectByUserid(Integer id);
}
