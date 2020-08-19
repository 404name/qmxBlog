package com.qmx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
    @TableField(exist = false)
    private Integer likes;
    @TableField(exist = false)
    private List<Integer> followset;
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getTocommentid() {
        return tocommentid;
    }

    public void setTocommentid(Integer tocommentid) {
        this.tocommentid = tocommentid;
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

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
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
