package com.dao;

import com.entity.AnzhikuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnzhikuView;

/**
 * 案知库 Dao 接口
 *
 * @author 
 */
public interface AnzhikuDao extends BaseMapper<AnzhikuEntity> {

   List<AnzhikuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
