package com.qmx.demo.service;

import com.qmx.demo.entity.Homepage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-24
 */
public interface HomepageService extends IService<Homepage> {
    List<Homepage> selectAll();
}
