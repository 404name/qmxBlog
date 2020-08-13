package com.qmx.demo.service;

import com.qmx.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
public interface UserService extends IService<User> {
    Integer getUserclassNum(Integer userclass);
    Integer getUserNum();
}
