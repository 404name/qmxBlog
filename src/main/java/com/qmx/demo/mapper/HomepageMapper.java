package com.qmx.demo.mapper;

import com.qmx.demo.entity.Homepage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Posting;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 404name
 * @since 2020-08-24
 */
@Repository
public interface HomepageMapper extends BaseMapper<Homepage> {
    @Select("SELECT * FROM homepage ORDER BY priority, updatadate DESC")
    List<Homepage> selectAll();
}
