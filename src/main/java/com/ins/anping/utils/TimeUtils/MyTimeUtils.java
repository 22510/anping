package com.ins.anping.utils.TimeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MyTimeUtils {

//
//    public static void main(String[] args) {
//        System.out.println(getNow());
//        System.out.println(getAfterTime(5L));
//    }

    public static String getNow(){
        LocalDateTime today = LocalDateTime.now();
        return today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String getAfterTime(Long day){
        LocalDateTime today = LocalDateTime.now();
        return today.plusDays(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
