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
import io.swagger.models.auth.In;
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

    private String schoolid;

    @ApiModelProperty(value = "0 男 1女 2保密")
    private Integer gender;

    @ApiModelProperty(value = "  class 0游客 1开发组组员 2智能组组员 3老师 （4管理员）")
    private Integer userclass;

    @ApiModelProperty(value = "点赞喜欢")
    private Integer likes;

    private String headsculpture;

    private String headpicture;

    private Date registerdate;

    private Date birthday;

    private String introduction;

    private String phonenumber;

    private String gitpage;

    private String institute;

    private String major;

    private Integer enrollmentyear;
    @TableField(exist = false)
    private Integer collectionnum;
    @TableField(exist = false)
    private List<Posting> collectionset;
    @TableField(exist = false)
    private Integer mypostingnum;
    @TableField(exist = false)
    private List<Posting> mypostingset;
    @TableField(exist = false)
    private Integer follownum;
    @TableField(exist = false)
    private List<Integer> followidset;
    @TableField(exist = false)
    private Integer befollownum;
    @TableField(exist = false)
    private List<Integer> befollowidset;

    public Integer getBefollownum() {
        return befollownum;
    }

    public void setBefollownum(Integer befollownum) {
        this.befollownum = befollownum;
    }

    public List<Integer> getBefollowidset() {
        return befollowidset;
    }

    public void setBefollowidset(List<Integer> befollowidset) {
        this.befollowidset = befollowidset;
    }

    public Integer getFollownum() {
        return follownum;
    }

    public void setFollownum(Integer follownum) {
        this.follownum = follownum;
    }

    public List<Integer> getFollowidset() {
        return followidset;
    }

    public void setFollowidset(List<Integer> followidset) {
        this.followidset = followidset;
    }

    public Integer getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(Integer collectionnum) {
        this.collectionnum = collectionnum;
    }

    public List<Posting> getCollectionset() {
        return collectionset;
    }

    public void setCollectionset(List<Posting> collectionset) {
        this.collectionset = collectionset;
    }

    public List<Posting> getMypostingset() {
        return mypostingset;
    }

    public void setMypostingset(List<Posting> mypostingset) {
        this.mypostingset = mypostingset;
    }

    public Integer getMypostingnum() {
        return mypostingnum;
    }

    public void setMypostingnum(Integer mypostingnum) {
        this.mypostingnum = mypostingnum;
    }



    @ApiModelProperty(value = "0")
    private Integer deleted;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getUserclass() {
        return userclass;
    }

    public void setUserclass(Integer userclass) {
        this.userclass = userclass;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getHeadsculpture() {
        return headsculpture;
    }

    public void setHeadsculpture(String headsculpture) {
        this.headsculpture = headsculpture;
    }

    public String getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(String headpicture) {
        this.headpicture = headpicture;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGitpage() {
        return gitpage;
    }

    public void setGitpage(String gitpage) {
        this.gitpage = gitpage;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getEnrollmentyear() {
        return enrollmentyear;
    }

    public void setEnrollmentyear(Integer enrollmentyear) {
        this.enrollmentyear = enrollmentyear;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
