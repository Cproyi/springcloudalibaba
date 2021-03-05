package com.huangyuan.userservice.modules.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-04
 */
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField("eName")
    private String eName;

    /**
     * M,F
     */
    private String gender;

    private Integer age;

    private LocalDate birthday;

    private String icon;

    private String address;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("updateTime")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public TUser setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public TUser setName(String name) {
        this.name = name;
        return this;
    }
    public String geteName() {
        return eName;
    }

    public TUser seteName(String eName) {
        this.eName = eName;
        return this;
    }
    public String getGender() {
        return gender;
    }

    public TUser setGender(String gender) {
        this.gender = gender;
        return this;
    }
    public Integer getAge() {
        return age;
    }

    public TUser setAge(Integer age) {
        this.age = age;
        return this;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public TUser setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
    public String getIcon() {
        return icon;
    }

    public TUser setIcon(String icon) {
        this.icon = icon;
        return this;
    }
    public String getAddress() {
        return address;
    }

    public TUser setAddress(String address) {
        this.address = address;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TUser setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public TUser setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TUser{" +
            "id=" + id +
            ", name=" + name +
            ", eName=" + eName +
            ", gender=" + gender +
            ", age=" + age +
            ", birthday=" + birthday +
            ", icon=" + icon +
            ", address=" + address +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
