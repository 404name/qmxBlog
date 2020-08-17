package com.qmx.demo.service;

import com.qmx.demo.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-17
 */
public interface FollowService extends IService<Follow> {
    List<Integer> getFollowUserByid(Integer id);
    Integer getFollowNumByid(Integer id);
}
