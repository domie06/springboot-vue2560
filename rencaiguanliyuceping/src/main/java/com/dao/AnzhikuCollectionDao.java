package com.dao;

import com.entity.AnzhikuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnzhikuCollectionView;

/**
 * 案知库收藏 Dao 接口
 *
 * @author 
 */
public interface AnzhikuCollectionDao extends BaseMapper<AnzhikuCollectionEntity> {

   List<AnzhikuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
