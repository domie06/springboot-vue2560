package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 案知库
 *
 * @author 
 * @email
 */
@TableName("anzhiku")
public class AnzhikuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnzhikuEntity() {

	}

	public AnzhikuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 案知库名称
     */
    @TableField(value = "anzhiku_name")

    private String anzhikuName;


    /**
     * 案知库照片
     */
    @TableField(value = "anzhiku_photo")

    private String anzhikuPhoto;


    /**
     * 案知库类型
     */
    @TableField(value = "anzhiku_types")

    private Integer anzhikuTypes;


    /**
     * 点击次数
     */
    @TableField(value = "anzhiku_clicknum")

    private Integer anzhikuClicknum;


    /**
     * 赞数量
     */
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩数量
     */
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 案知库详情
     */
    @TableField(value = "anzhiku_content")

    private String anzhikuContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "anzhiku_delete")

    private Integer anzhikuDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：案知库名称
	 */
    public String getAnzhikuName() {
        return anzhikuName;
    }


    /**
	 * 获取：案知库名称
	 */

    public void setAnzhikuName(String anzhikuName) {
        this.anzhikuName = anzhikuName;
    }
    /**
	 * 设置：案知库照片
	 */
    public String getAnzhikuPhoto() {
        return anzhikuPhoto;
    }


    /**
	 * 获取：案知库照片
	 */

    public void setAnzhikuPhoto(String anzhikuPhoto) {
        this.anzhikuPhoto = anzhikuPhoto;
    }
    /**
	 * 设置：案知库类型
	 */
    public Integer getAnzhikuTypes() {
        return anzhikuTypes;
    }


    /**
	 * 获取：案知库类型
	 */

    public void setAnzhikuTypes(Integer anzhikuTypes) {
        this.anzhikuTypes = anzhikuTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getAnzhikuClicknum() {
        return anzhikuClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setAnzhikuClicknum(Integer anzhikuClicknum) {
        this.anzhikuClicknum = anzhikuClicknum;
    }
    /**
	 * 设置：赞数量
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞数量
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩数量
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩数量
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：案知库详情
	 */
    public String getAnzhikuContent() {
        return anzhikuContent;
    }


    /**
	 * 获取：案知库详情
	 */

    public void setAnzhikuContent(String anzhikuContent) {
        this.anzhikuContent = anzhikuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getAnzhikuDelete() {
        return anzhikuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setAnzhikuDelete(Integer anzhikuDelete) {
        this.anzhikuDelete = anzhikuDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Anzhiku{" +
            "id=" + id +
            ", anzhikuName=" + anzhikuName +
            ", anzhikuPhoto=" + anzhikuPhoto +
            ", anzhikuTypes=" + anzhikuTypes +
            ", anzhikuClicknum=" + anzhikuClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", anzhikuContent=" + anzhikuContent +
            ", anzhikuDelete=" + anzhikuDelete +
            ", createTime=" + createTime +
        "}";
    }
}
