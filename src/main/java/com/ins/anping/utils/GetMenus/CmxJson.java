package com.ins.anping.utils.GetMenus;


import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class CmxJson {

    public static List<Map<String, Object>> getLmo(String s){
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> x = (List<Map<String, Object>>) JSON.parse(s);
        return x;
    }

    public static List<Map<String, String>> getLm(String s){
        @SuppressWarnings("unchecked")
        List<Map<String, String>> x = (List<Map<String, String>>) JSON.parse(s);
        return x;
    }

    public static Map<String, String> getMap(String s){
        @SuppressWarnings("unchecked")
        Map<String, String> x = (Map<String, String>) JSON.parse(s);
        return x;
    }

    public static Map<String, Object> getMo(String s){
        @SuppressWarnings("unchecked")
        Map<String, Object> x = (Map<String, Object>) JSON.parse(s);
        return x;
    }

    public static List<String> getList(String s){
        @SuppressWarnings("unchecked")
        List<String> x = (List<String>) JSON.parse(s);
        return x;
    }

    public static List<Object> geLo(String s){
        @SuppressWarnings("unchecked")
        List<Object> x = (List<Object>) JSON.parse(s);
        return x;
    }

//    public static void main(String[] args) {
//        CmxConf cmxConf = new CmxConf();
//        List<String> menuList = MyDictHz.getMenuList(cmxConf);
//        logger.info(menuList);
//        //	System.out.println(CmxJson.getLmo(s));
//        //	System.out.println(x);
//
//    }
}