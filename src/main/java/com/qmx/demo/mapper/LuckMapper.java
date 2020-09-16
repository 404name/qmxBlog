package com.qmx.demo.mapper;

import com.qmx.demo.entity.Luck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmx.demo.entity.Message;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 404name
 * @since 2020-09-16
 */
@Repository
public interface LuckMapper extends BaseMapper<Luck> {
    @Select("SELECT * FROM `luck` Where `name` like '开发组 % 2020%' or name like '智能组 % 2020%'")
    List<Luck> get2020Student();
}
