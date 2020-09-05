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
 * @since 2020-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Message对象", description="")
public class Message implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Date date;

    private Integer messageclass;

    private String title;

    private Integer touserid;

    private String herf;


    public Message(Integer touserid0, String title0, String herf0) {
        touserid = touserid0;
        title = title0;
        herf = herf0;
    }
    public Message(Integer touserid0, String title0, String herf0,Integer messageclass0) {
        touserid = touserid0;
        title = title0;
        herf = herf0;
        messageclass = messageclass0;
    }

    public Message(Integer id, Date date, Integer messageclass, String title, Integer touserid, String herf) {
        this.id = id;
        this.date = date;
        this.messageclass = messageclass;
        this.title = title;
        this.touserid = touserid;
        this.herf = herf;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMessageclass() {
        return messageclass;
    }

    public void setMessageclass(Integer messageclass) {
        this.messageclass = messageclass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getHerf() {
        return herf;
    }

    public void setHerf(String herf) {
        this.herf = herf;
    }
}
