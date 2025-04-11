package com.entity.view;

import com.entity.AnzhikuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 案知库留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("anzhiku_liuyan")
public class AnzhikuLiuyanView extends AnzhikuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 anzhiku
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
				* 案知库类型的值
				*/
				private String anzhikuValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public AnzhikuLiuyanView() {

	}

	public AnzhikuLiuyanView(AnzhikuLiuyanEntity anzhikuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, anzhikuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set anzhiku
					/**
					* 获取： 案知库名称
					*/
					public String getAnzhikuName() {
						return anzhikuName;
					}
					/**
					* 设置： 案知库名称
					*/
					public void setAnzhikuName(String anzhikuName) {
						this.anzhikuName = anzhikuName;
					}
					/**
					* 获取： 案知库照片
					*/
					public String getAnzhikuPhoto() {
						return anzhikuPhoto;
					}
					/**
					* 设置： 案知库照片
					*/
					public void setAnzhikuPhoto(String anzhikuPhoto) {
						this.anzhikuPhoto = anzhikuPhoto;
					}
					/**
					* 获取： 案知库类型
					*/
					public Integer getAnzhikuTypes() {
						return anzhikuTypes;
					}
					/**
					* 设置： 案知库类型
					*/
					public void setAnzhikuTypes(Integer anzhikuTypes) {
						this.anzhikuTypes = anzhikuTypes;
					}


						/**
						* 获取： 案知库类型的值
						*/
						public String getAnzhikuValue() {
							return anzhikuValue;
						}
						/**
						* 设置： 案知库类型的值
						*/
						public void setAnzhikuValue(String anzhikuValue) {
							this.anzhikuValue = anzhikuValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getAnzhikuClicknum() {
						return anzhikuClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setAnzhikuClicknum(Integer anzhikuClicknum) {
						this.anzhikuClicknum = anzhikuClicknum;
					}
					/**
					* 获取： 赞数量
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞数量
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}
					/**
					* 获取： 踩数量
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩数量
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}
					/**
					* 获取： 案知库详情
					*/
					public String getAnzhikuContent() {
						return anzhikuContent;
					}
					/**
					* 设置： 案知库详情
					*/
					public void setAnzhikuContent(String anzhikuContent) {
						this.anzhikuContent = anzhikuContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getAnzhikuDelete() {
						return anzhikuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setAnzhikuDelete(Integer anzhikuDelete) {
						this.anzhikuDelete = anzhikuDelete;
					}




























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
