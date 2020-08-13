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
    private String introduction;//个性介绍
    private String phonenumber;
    private String gitpage;//git主页
    private String school;//就读学校
    private String institute;//所在学院
    private int enrollmentyear;//入学年份

    @ApiModelProperty(value = "0")
    private Integer deleted;

    public User(String username, String email, String password, String schoolid, Integer gender, Integer userclass, Integer likes, String headsculpture, String headpicture, Date registerdate, Date birthday, String introduction, String phonenumber, String gitpage, String school, String institute, int enrollmentyear, Integer deleted) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.schoolid = schoolid;
        this.gender = gender;
        this.userclass = userclass;
        this.likes = likes;
        this.headsculpture = headsculpture;
        this.headpicture = headpicture;
        this.registerdate = registerdate;
        this.birthday = birthday;
        this.introduction = introduction;
        this.phonenumber = phonenumber;
        this.gitpage = gitpage;
        this.school = school;
        this.institute = institute;
        this.enrollmentyear = enrollmentyear;
        this.deleted = deleted;
    }

    public User(String username, String email, String password, String schoolid, Integer gender, Integer userclass, Date birthday, String introduction, String phonenumber, String gitpage, String school, String institute, int enrollmentyear) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.schoolid = schoolid;
        this.gender = gender;
        this.userclass = userclass;
        this.birthday = birthday;
        this.introduction = introduction;
        this.phonenumber = phonenumber;
        this.gitpage = gitpage;
        this.school = school;
        this.institute = institute;
        this.enrollmentyear = enrollmentyear;
    }

    public User(String username, String email, String password, String schoolid, Integer gender, Integer userclass) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.schoolid = schoolid;
        this.gender = gender;
        this.userclass = userclass;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getEnrollmentyear() {
        return enrollmentyear;
    }

    public void setEnrollmentyear(int enrollmentyear) {
        this.enrollmentyear = enrollmentyear;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", schoolid='" + schoolid + '\'' +
                ", gender=" + gender +
                ", userclass=" + userclass +
                ", likes=" + likes +
                ", headsculpture='" + headsculpture + '\'' +
                ", headpicture='" + headpicture + '\'' +
                ", registerdate=" + registerdate +
                ", birthday=" + birthday +
                ", introduction='" + introduction + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", gitpage='" + gitpage + '\'' +
                ", school='" + school + '\'' +
                ", institute='" + institute + '\'' +
                ", enrollmentyear=" + enrollmentyear +
                ", deleted=" + deleted +
                '}';
    }
}
