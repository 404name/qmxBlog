package com.qmx.demo.service;

import com.qmx.demo.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-09-05
 */
public interface MessageService extends IService<Message> {
    List<Message> selectByUserid(Integer id);
}
