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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "默认真实姓名")
    private String username;

    @ApiModelProperty(value = "邮箱 登录可用")
    private String email;

    private String password;

    private Integer age;

    @ApiModelProperty(value = "0 男 1女")
    private Integer gender;

    @ApiModelProperty(value = "  class 0游客 1开发组组员 2智能组组员 3老师 （4管理员）")
    private Integer userclass;

    @ApiModelProperty(value = "点赞喜欢")
    private Integer likes;

    private String headsculpture;

    private String headpicture;

    private Date registerdate;

    @ApiModelProperty(value = "0")
    private Integer deleted;


}
