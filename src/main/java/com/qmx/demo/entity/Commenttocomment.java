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
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Commenttocomment对象", description="")
public class Commenttocomment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id主键唯一")
      @TableId(value = "commentid", type = IdType.AUTO)
    private Integer commentid;

    @ApiModelProperty(value = "")
    private Integer tocommentid;

    @ApiModelProperty(value = "用户id")
    private Integer userid;

    @ApiModelProperty(value = "用户姓名，创建时填入方便查询")
    private String username;

    @ApiModelProperty(value = "回复谁")
    private Integer touserid;

    @ApiModelProperty(value = "方便查询")
    private String tousername;

    @ApiModelProperty(value = "回复内容")
    private String commentcontent;

    @ApiModelProperty(value = "回复时间")
    private Date commentdate;

    @ApiModelProperty(value = "最后修改时间")
    private Date updatadate;

    @ApiModelProperty(value = "逻辑删除，备用")
    private Integer deleted;
}
