package com.dao;

import com.entity.AnzhikuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnzhikuLiuyanView;

/**
 * 案知库留言 Dao 接口
 *
 * @author 
 */
public interface AnzhikuLiuyanDao extends BaseMapper<AnzhikuLiuyanEntity> {

   List<AnzhikuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
