package com.qmx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Set;

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
 * @since 2020-08-07
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Userclass对象", description="")
public class Userclass implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userclass;

    private String userclassname;

    @TableField(exist = false)
    private Integer userclassnum;

    public Integer getUserclassnum() {
        return userclassnum;
    }

    public void setUserclassnum(Integer userclassnum) {
        this.userclassnum = userclassnum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserclass() {
        return userclass;
    }

    public void setUserclass(Integer userclass) {
        this.userclass = userclass;
    }

    public String getUserclassname() {
        return userclassname;
    }

    public void setUserclassname(String userclassname) {
        this.userclassname = userclassname;
    }
}
