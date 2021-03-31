package com.huangyuan.userservice.modules.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangyuan
 * @since 2021-03-31
 */
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public TRole setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public TRole setName(String name) {
        this.name = name;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public TRole setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public TRole setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TRole{" +
            "id=" + id +
            ", name=" + name +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
