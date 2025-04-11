package com.entity.vo;

import com.entity.AnzhikuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 案知库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("anzhiku")
public class AnzhikuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
