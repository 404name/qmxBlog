package com.qmx.demo.service;

import com.qmx.demo.entity.Postingclass;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-07
 */
public interface PostingclassService extends IService<Postingclass> {
    List<Postingclass> selectAll();
}
