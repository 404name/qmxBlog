package com.qmx.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;
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

    private Integer commentnum;
    private Integer collectionnum;
    private  String imgsrc;
    @TableField(exist = false)
    private List<Comment> commentset;

    @TableField(exist = false)
    private List<Integer> collectionuserid;

    public Integer getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(Integer collectionnum) {
        this.collectionnum = collectionnum;
    }


    public List<Comment> getCommentset() {
        return commentset;
    }

    public void setCommentset(List<Comment> commentset) {
        this.commentset = commentset;
    }

    public List<Integer> getCollectionuserid() {
        return collectionuserid;
    }

    public void setCollectionuserid(List<Integer> collectionuserid) {
        this.collectionuserid = collectionuserid;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

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
