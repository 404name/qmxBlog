package com.qmx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-08-07
 */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Postingclass对象", description="")
public class Postingclass implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer postingclass;

    private String postingclassname;

    @TableField(exist = false)
    private Integer postingclassnum;

    public Integer getPostingclassnum() {
        return postingclassnum;
    }

    public void setPostingclassnum(Integer postingclassnum) {
        this.postingclassnum = postingclassnum;
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

    public Integer getPostingclass() {
        return postingclass;
    }

    public void setPostingclass(Integer postingclass) {
        this.postingclass = postingclass;
    }

    public String getPostingclassname() {
        return postingclassname;
    }

    public void setPostingclassname(String postingclassname) {
        this.postingclassname = postingclassname;
    }
}
