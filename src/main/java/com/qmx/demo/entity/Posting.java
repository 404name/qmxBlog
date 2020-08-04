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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPostingid() {
        return postingid;
    }

    public void setPostingid(Integer postingid) {
        this.postingid = postingid;
    }

    public Integer getPostingclass() {
        return postingclass;
    }

    public void setPostingclass(Integer postingclass) {
        this.postingclass = postingclass;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostingtitle() {
        return postingtitle;
    }

    public void setPostingtitle(String postingtitle) {
        this.postingtitle = postingtitle;
    }

    public String getPostingcontent() {
        return postingcontent;
    }

    public void setPostingcontent(String postingcontent) {
        this.postingcontent = postingcontent;
    }

    public Date getPostingdate() {
        return postingdate;
    }

    public void setPostingdate(Date postingdate) {
        this.postingdate = postingdate;
    }

    public Date getUpdatadate() {
        return updatadate;
    }

    public void setUpdatadate(Date updatadate) {
        this.updatadate = updatadate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
