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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getTopostingid() {
        return topostingid;
    }

    public void setTopostingid(Integer topostingid) {
        this.topostingid = topostingid;
    }

    public Integer getTocommentid() {
        return tocommentid;
    }

    public void setTocommentid(Integer tocommentid) {
        this.tocommentid = tocommentid;
    }

    public Integer getCommentclass() {
        return commentclass;
    }

    public void setCommentclass(Integer commentclass) {
        this.commentclass = commentclass;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
