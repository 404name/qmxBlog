package com.qmx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 404name
 * @since 2020-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "commentid", type = IdType.AUTO)
    private Integer commentid;

    private Integer topostingid;

    private Integer tocommentid;

    @ApiModelProperty(value = "0 文章评论 1文章评论回复 2留言")
    private Integer commentclass;

    @ApiModelProperty(value = "点赞 喜欢")
    private Integer likes;

    private Integer id;

    private String name;

    private String commentcontent;

    @ApiModelProperty(value = "评论发布时间")
    private Date commentdate;

    @ApiModelProperty(value = "评论修改时间")
    private Date updatadate;

    @ApiModelProperty(value = "逻辑删除")
    private Integer deleted;


}
