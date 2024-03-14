package com.ins.anping.utils.WebSocketUtils.testSome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMap {
    public static void main(String[] args) {
//        Map<String, List<String>> map = new HashMap<>();
//        List<String> stringList = map.getOrDefault("Qinghe", new ArrayList<>());
//        stringList.add("111");
//        map.put("Qinghe", stringList);
//        System.out.println(map.get("Qinghe").toString());
//        List<String> qinghe = map.get("Qinghe");
//        qinghe.add("222");
//        map.put("Qinghe", qinghe);
//        System.out.println(map.get("Qinghe").toString());
        Map<String, List<Integer>> stringLength = new HashMap<>();
        stringLength.computeIfAbsent("John", k -> new ArrayList<>()).add(111);
        stringLength.computeIfAbsent("John", k -> new ArrayList<>()).add(222);

        stringLength.computeIfAbsent("Qehing", k -> new ArrayList<>()).add(111);
        stringLength.computeIfAbsent("Qehing", k -> new ArrayList<>()).add(222);
        System.out.println(stringLength.toString());
    }
}
