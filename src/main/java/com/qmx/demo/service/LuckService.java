package com.qmx.demo.service;

import com.qmx.demo.entity.Luck;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-09-16
 */
public interface LuckService extends IService<Luck> {
    List<Luck> get2020Student();
}
