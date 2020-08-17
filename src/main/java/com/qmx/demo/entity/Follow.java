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
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Follow对象", description="")
public class Follow implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userid;

    private String username;

    private Integer followid;

    private String followname;

    private Date followdate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    public String getFollowname() {
        return followname;
    }

    public void setFollowname(String followname) {
        this.followname = followname;
    }

    public Date getFollowdate() {
        return followdate;
    }

    public void setFollowdate(Date followdate) {
        this.followdate = followdate;
    }
}
