package com.ins.anping.utils;

import java.util.regex.Pattern;

public class isInteger {
    public static void main(String[] args) {
        String userName = "123456a";
        System.out.println(isInteger(userName));
    }
    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
