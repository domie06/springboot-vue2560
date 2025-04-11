
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 案知库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/anzhiku")
public class AnzhikuController {
    private static final Logger logger = LoggerFactory.getLogger(AnzhikuController.class);

    @Autowired
    private AnzhikuService anzhikuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("anzhikuDeleteStart",1);params.put("anzhikuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = anzhikuService.queryPage(params);

        //字典表数据转换
        List<AnzhikuView> list =(List<AnzhikuView>)page.getList();
        for(AnzhikuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnzhikuEntity anzhiku = anzhikuService.selectById(id);
        if(anzhiku !=null){
            //entity转view
            AnzhikuView view = new AnzhikuView();
            BeanUtils.copyProperties( anzhiku , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnzhikuEntity anzhiku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,anzhiku:{}",this.getClass().getName(),anzhiku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<AnzhikuEntity> queryWrapper = new EntityWrapper<AnzhikuEntity>()
            .eq("anzhiku_name", anzhiku.getAnzhikuName())
            .eq("anzhiku_types", anzhiku.getAnzhikuTypes())
            .eq("anzhiku_clicknum", anzhiku.getAnzhikuClicknum())
            .eq("zan_number", anzhiku.getZanNumber())
            .eq("cai_number", anzhiku.getCaiNumber())
            .eq("anzhiku_delete", anzhiku.getAnzhikuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnzhikuEntity anzhikuEntity = anzhikuService.selectOne(queryWrapper);
        if(anzhikuEntity==null){
            anzhiku.setAnzhikuClicknum(1);
            anzhiku.setAnzhikuDelete(1);
            anzhiku.setCreateTime(new Date());
            anzhikuService.insert(anzhiku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnzhikuEntity anzhiku, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,anzhiku:{}",this.getClass().getName(),anzhiku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<AnzhikuEntity> queryWrapper = new EntityWrapper<AnzhikuEntity>()
            .notIn("id",anzhiku.getId())
            .andNew()
            .eq("anzhiku_name", anzhiku.getAnzhikuName())
            .eq("anzhiku_types", anzhiku.getAnzhikuTypes())
            .eq("anzhiku_clicknum", anzhiku.getAnzhikuClicknum())
            .eq("zan_number", anzhiku.getZanNumber())
            .eq("cai_number", anzhiku.getCaiNumber())
            .eq("anzhiku_delete", anzhiku.getAnzhikuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnzhikuEntity anzhikuEntity = anzhikuService.selectOne(queryWrapper);
        if("".equals(anzhiku.getAnzhikuPhoto()) || "null".equals(anzhiku.getAnzhikuPhoto())){
                anzhiku.setAnzhikuPhoto(null);
        }
        if(anzhikuEntity==null){
            anzhikuService.updateById(anzhiku);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<AnzhikuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            AnzhikuEntity anzhikuEntity = new AnzhikuEntity();
            anzhikuEntity.setId(id);
            anzhikuEntity.setAnzhikuDelete(2);
            list.add(anzhikuEntity);
        }
        if(list != null && list.size() >0){
            anzhikuService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<AnzhikuEntity> anzhikuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            AnzhikuEntity anzhikuEntity = new AnzhikuEntity();
//                            anzhikuEntity.setAnzhikuName(data.get(0));                    //案知库名称 要改的
//                            anzhikuEntity.setAnzhikuPhoto("");//照片
//                            anzhikuEntity.setAnzhikuTypes(Integer.valueOf(data.get(0)));   //案知库类型 要改的
//                            anzhikuEntity.setAnzhikuClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            anzhikuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞数量 要改的
//                            anzhikuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩数量 要改的
//                            anzhikuEntity.setAnzhikuContent("");//照片
//                            anzhikuEntity.setAnzhikuDelete(1);//逻辑删除字段
//                            anzhikuEntity.setCreateTime(date);//时间
                            anzhikuList.add(anzhikuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        anzhikuService.insertBatch(anzhikuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = anzhikuService.queryPage(params);

        //字典表数据转换
        List<AnzhikuView> list =(List<AnzhikuView>)page.getList();
        for(AnzhikuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnzhikuEntity anzhiku = anzhikuService.selectById(id);
            if(anzhiku !=null){

                //点击数量加1
                anzhiku.setAnzhikuClicknum(anzhiku.getAnzhikuClicknum()+1);
                anzhikuService.updateById(anzhiku);

                //entity转view
                AnzhikuView view = new AnzhikuView();
                BeanUtils.copyProperties( anzhiku , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody AnzhikuEntity anzhiku, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,anzhiku:{}",this.getClass().getName(),anzhiku.toString());
        Wrapper<AnzhikuEntity> queryWrapper = new EntityWrapper<AnzhikuEntity>()
            .eq("anzhiku_name", anzhiku.getAnzhikuName())
            .eq("anzhiku_types", anzhiku.getAnzhikuTypes())
            .eq("anzhiku_clicknum", anzhiku.getAnzhikuClicknum())
            .eq("zan_number", anzhiku.getZanNumber())
            .eq("cai_number", anzhiku.getCaiNumber())
            .eq("anzhiku_delete", anzhiku.getAnzhikuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnzhikuEntity anzhikuEntity = anzhikuService.selectOne(queryWrapper);
        if(anzhikuEntity==null){
            anzhiku.setAnzhikuDelete(1);
            anzhiku.setCreateTime(new Date());
        anzhikuService.insert(anzhiku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
