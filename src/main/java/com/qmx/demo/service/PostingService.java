package com.qmx.demo.service;

import com.qmx.demo.entity.Posting;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
public interface PostingService extends IService<Posting> {
    Posting selectByPositngId(Integer postingid);
    List<Posting> selectAll();
    Integer getPostingclassNum(Integer postingclass);
    Integer getPostingNum();
//    Void increasePostingLikes(Integer postingid);

    Integer getUserPostingNum(Integer id);
    List<Posting> selectByid(Integer id);
    List<Posting>  selectCollectionByUserid(Integer id);
}
