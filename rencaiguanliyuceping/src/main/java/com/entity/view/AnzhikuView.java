package com.entity.view;

import com.entity.AnzhikuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 案知库
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("anzhiku")
public class AnzhikuView extends AnzhikuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 案知库类型的值
		*/
		private String anzhikuValue;



	public AnzhikuView() {

	}

	public AnzhikuView(AnzhikuEntity anzhikuEntity) {
		try {
			BeanUtils.copyProperties(this, anzhikuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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













}
