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
@ApiModel(value="Posting对象", description="")
public class Posting implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "postingid", type = IdType.AUTO)
    private Integer postingid;

    @ApiModelProperty(value = "帖子类型")
    private Integer postingclass;

    private Integer likes;

    private Integer id;

    private String username;

    private String postingtitle;

    private String postingcontent;

    private Date postingdate;

    private Date updatadate;

    private Integer deleted;


}
