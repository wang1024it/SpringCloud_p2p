package com.wyy.common_p2p.aspect;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyy.common_p2p.aspect.annotation.Dict;
import com.wyy.common_p2p.constant.CommonConstant;
import com.wyy.common_p2p.rpc.sys.SysdictitemFeignApi;
import com.wyy.common_p2p.utils.PageUtils;
import com.wyy.common_p2p.utils.oConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 字典aop类 (用于翻译字典数据)
 * @Author: cpc
 * @Date: 2019-3-17 21:50
 * @Version: 1.0
 */
@Aspect
@Component
@Slf4j
public class DictAspect {
    @Autowired
    private SysdictitemFeignApi sysdictitemFeignApi;

    // 定义切点Pointcut
    @Pointcut("execution( * com.wyy..controller.*.*(..))")
    public void excudeService() {
    }

    /**
     * 这是触发 excudeService 的时候会执行的
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        //这是定义开始事件
    	long time1= System.currentTimeMillis();
    	//这是方法并获取返回结果
        Object result = pjp.proceed();
        //这是获取到 结束时间
        long time2= System.currentTimeMillis();
        log.debug("获取JSON数据 耗时："+(time2-time1)+"ms");
        //解析开始时间
        long start= System.currentTimeMillis();
        //开始解析（翻译字段内部的值）
        this.parseDictText(result);
        //解析结束时间
        long end= System.currentTimeMillis();
        log.debug("解析注入JSON数据  耗时"+(end-start)+"ms");
        return result;
    }

    /**
     * 本方法针对返回对象为Result 的IPage的分页列表数据进行动态字典注入
     * 字典注入实现 通过对实体类添加注解@dict 来标识需要的字典内容,字典分为单字典code即可 ，table字典 code table text配合使用与原来jeecg的用法相同
     * 示例为SysUser   字段为sex 添加了注解@Dict(dicCode = "sex") 会在字典服务立马查出来对应的text 然后在请求list的时候将这个字典text，已字段名称加_dictText形式返回到前端
     * 例输入当前返回值的就会多出一个sex_dictText字段
     * {
     *      sex:1,
     *      sex_dictText:"男"
     * }
     * 前端直接取值sext_dictText在table里面无需再进行前端的字典转换了
     *  customRender:function (text) {
     *               if(text==1){
     *                 return "男";
     *               }else if(text==2){
     *                 return "女";
     *               }else{
     *                 return text;
     *               }
     *             }
     *             目前vue是这么进行字典渲染到table上的多了就很麻烦了 这个直接在服务端渲染完成前端可以直接用
     * @param result
     */
    private void parseDictText(Object result) {
        if (result instanceof PageUtils) {
                List<JSONObject> items = new ArrayList<>();
                PageUtils pageUtils = (PageUtils)result;
                //循环查找出来的数据
                for (Object record :  pageUtils.getData()) {
                    ObjectMapper mapper = new ObjectMapper();
                    String json="{}";
                    try {
                        //解决@JsonFormat注解解析不了的问题详见SysAnnouncement类的@JsonFormat
                        json = mapper.writeValueAsString(record);
                    } catch (JsonProcessingException e) {
                        log.error("json解析失败"+e.getMessage(),e);
                    }
                    JSONObject item = JSONObject.parseObject(json);

                    //update-begin--Author:scott -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
                    //for (Field field : record.getClass().getDeclaredFields()) {
                    for (Field field : oConvertUtils.getAllFields(record)) {
                        //update-end--Author:scott  -- Date:20190603 ----for：解决继承实体字段无法翻译问题------
                        if (field.getAnnotation(Dict.class) != null) {
                            String code = field.getAnnotation(Dict.class).dicCode();
                            String text = field.getAnnotation(Dict.class).dicText();
                            //获取当前带翻译的值
                            String key = String.valueOf(item.get(field.getName()));
                            //翻译字典值对应的txt
                            String textValue = translateDictValue(code, key);

                            log.debug(" 字典Val : "+ textValue);
                            //  CommonConstant.DICT_TEXT_SUFFIX的值为，是模块
                            // public static final String DICT_TEXT_SUFFIX = "_dictText";
                            log.debug(" __翻译字典字段__ "+field.getName() + CommonConstant.DICT_TEXT_SUFFIX+"： "+ textValue);
                            //如果给了文本名
                            if(!StringUtils.isEmpty(text)){
                                item.put(text, textValue);
                            }else{
                                //走默认策略
                                item.put(field.getName() + CommonConstant.DICT_TEXT_SUFFIX, textValue);
                            }

                        }
                        //date类型默认转换string格式化日期
                        if (field.getType().getName().equals("java.util.Date")&&field.getAnnotation(JsonFormat.class)==null&&item.get(field.getName())!=null){
                            SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
                        }
                    }
                    items.add(item);
                }
                 pageUtils.setData(items);

            }
    }


    /**
          *  翻译字典文本
     * @param code
     * @param key
     * @return
     */
    private String translateDictValue(String code, String key) {
        //如果key为空直接返回就好了
    	if(oConvertUtils.isEmpty(key)) {
    		return null;
    	}
        StringBuffer textValue=new StringBuffer();
    	//分割 key 值
        String[] keys = key.split(",");
        //循环 keys 中的所有值
        for (String k : keys) {
            String tmpValue = null;
            log.debug(" 字典 key : "+ k);
            if (k.trim().length() == 0) {
                continue; //跳过循环
            }
            tmpValue = sysdictitemFeignApi.queryDictTextByKey(code, k.trim());

            if (tmpValue != null) {
                if (!"".equals(textValue.toString())) {
                    textValue.append(",");
                }
                textValue.append(tmpValue);
            }
        }
        //返回翻译的值
        return textValue.toString();
    }

}
