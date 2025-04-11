package com.entity.model;

import com.entity.AnzhikuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 案知库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnzhikuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 案知库名称
     */
    private String anzhikuName;


    /**
     * 案知库照片
     */
    private String anzhikuPhoto;


    /**
     * 案知库类型
     */
    private Integer anzhikuTypes;


    /**
     * 点击次数
     */
    private Integer anzhikuClicknum;


    /**
     * 赞数量
     */
    private Integer zanNumber;


    /**
     * 踩数量
     */
    private Integer caiNumber;


    /**
     * 案知库详情
     */
    private String anzhikuContent;


    /**
     * 逻辑删除
     */
    private Integer anzhikuDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：案知库名称
	 */
    public String getAnzhikuName() {
        return anzhikuName;
    }


    /**
	 * 设置：案知库名称
	 */
    public void setAnzhikuName(String anzhikuName) {
        this.anzhikuName = anzhikuName;
    }
    /**
	 * 获取：案知库照片
	 */
    public String getAnzhikuPhoto() {
        return anzhikuPhoto;
    }


    /**
	 * 设置：案知库照片
	 */
    public void setAnzhikuPhoto(String anzhikuPhoto) {
        this.anzhikuPhoto = anzhikuPhoto;
    }
    /**
	 * 获取：案知库类型
	 */
    public Integer getAnzhikuTypes() {
        return anzhikuTypes;
    }


    /**
	 * 设置：案知库类型
	 */
    public void setAnzhikuTypes(Integer anzhikuTypes) {
        this.anzhikuTypes = anzhikuTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getAnzhikuClicknum() {
        return anzhikuClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setAnzhikuClicknum(Integer anzhikuClicknum) {
        this.anzhikuClicknum = anzhikuClicknum;
    }
    /**
	 * 获取：赞数量
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞数量
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩数量
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩数量
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：案知库详情
	 */
    public String getAnzhikuContent() {
        return anzhikuContent;
    }


    /**
	 * 设置：案知库详情
	 */
    public void setAnzhikuContent(String anzhikuContent) {
        this.anzhikuContent = anzhikuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getAnzhikuDelete() {
        return anzhikuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setAnzhikuDelete(Integer anzhikuDelete) {
        this.anzhikuDelete = anzhikuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
