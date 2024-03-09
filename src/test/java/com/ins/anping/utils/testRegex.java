package com.ins.anping.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {


    public static void main(String[] args) {
//        String htbh = "工程名称：123x";
//        String regex_htbh = "(项目名称|工程名称)：(.*)";
//        Pattern pattern = Pattern.compile(regex_htbh);
//        Matcher matcher = pattern.matcher(htbh);
//        boolean b = matcher.find();
//        System.out.println(matcher.group(1));
        Map<String, String> contents = new HashMap<>();
        contents.put("合同编号", "合同编号：(.*)");
        contents.put("承租方", "承租方：(.*)");
        contents.put("出租方", "出租方：(.*)");
        contents.put("项目名称", "(项目名称|工程名称)：(.*)");
        contents.put("项目地址", "(项目地址|工程地点)：(.*)");
        contents.put("开户行", "(开户银行|开户行)：(.*)");
        contents.put("账号", "账号：(.*)");
//                {"合同编号：(.*)", "承租方：(.*)", "出租方：(.*)", "(项目名称|工程名称)：(.*)", "(项目地址|工程地点)：(.*)", "(开户银行|开户行)：(.*)", "账号：(.*)"};
        LinkedList<String> content2Match = new LinkedList<>();
        Map<String, Object> returnMap = new HashMap<>();
        String[] strs = new String[]{"合同编号：10099", "合同？？：啥也不是", "承租方：广C南宁无限可能", "出租方：广C南宁优先困难", "项目名称：1111",
                "工程名称：2222"};

        for (String str : strs){
            for(Map.Entry<String, String> entry : contents.entrySet()){
                Pattern pattern = Pattern.compile(entry.getValue());
                Matcher matcher = pattern.matcher(str);
                int index = 1;
                if (entry.getValue().contains("|")){
                    index = 2;
                }
                if (matcher.find()){
                    if (returnMap.get(entry.getKey()) != null){
                        returnMap.put(entry.getKey()+"_乙方", matcher.group(index));
                    }else{
                        returnMap.put(entry.getKey(), matcher.group(index));
                    }
                }
            }
        }
        System.out.println(returnMap.toString());
    }
}
