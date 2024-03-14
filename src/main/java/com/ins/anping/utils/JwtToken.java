package com.ins.anping.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtToken {

    private String key = "AnPingSyS_QeHing";

    public String createToken(Map<String, Object> mapInfo, Integer expiredTimeIn) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        JWTCreator.Builder builder = JWT.create();
        builder.withHeader(map);
        mapInfo.forEach((k, v) -> {
            builder.withClaim(k, v.toString());
        });
        Calendar timeNow = Calendar.getInstance();
//        System.out.println("过期时间:"+expiredTimeIn+"分钟");
        timeNow.add(Calendar.MINUTE, expiredTimeIn);
        builder.withExpiresAt(timeNow.getTime());
        return builder.sign(Algorithm.HMAC256("AnPingSyS_QeHing"));
    }

    public void verifyToken(String token){
        JWT.require(Algorithm.HMAC256(key))
                .build().verify(token);
    }

    // 去除S前后的引号
    private String myTrim(String s) {
        int start=0,end=s.length()-1;
        while(start<=end && s.charAt(start)=='"')
        {
            start++;
        }
        while(start<=end && s.charAt(end)=='"')
        {
            end--;
        }
        return s.substring(start,end+1);
    }


    private Map<String, Object>  claimToMap(Map<String, Claim>  claimMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "Token正常!");
        for(String keys : claimMap.keySet()) {
            map.put(keys, claimMap.get(keys).toString());
        }
        return map;
    }

    //
    public Map<String, Object> DecodedJWT(String token, String[] indexS) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("AnPingSyS_QeHing")).build();

        Map<String, Object> returenMap = new HashMap<>();
        try {
            DecodedJWT jwt = verifier.verify(token);
            returenMap.put("code", 0);
            returenMap.put("msg", "Token正常!");
            for(String index : indexS){
                returenMap.put(index, jwt.getClaim(index).asString());
            }
            return returenMap;
        }catch(TokenExpiredException e) {
            returenMap.put("code", -1);
            returenMap.put("msg", "Token已过期!");
        }catch(SignatureVerificationException e) {
            returenMap.put("code", -2);
            returenMap.put("msg", "签名错误!");
            throw e;
        }catch(AlgorithmMismatchException e) {
            returenMap.put("code", -3);
            returenMap.put("msg", "签名错误!");
            throw e;
        }catch(Exception e) {
            returenMap.put("code", -4);
            returenMap.put("msg", "无效Token!");
            throw e;
        }
        return returenMap;
    }


    public static void main(String[] args) throws Exception {
        JwtToken jwtToken = new JwtToken();
//        jwtToken.expiredTimeIn = 12;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "zhangsan");
//        map.put("age", 22);
//        map.put("Address", "可我忘了第三方是的范德萨发斯蒂芬对方身上打发大水发");
//        System.out.println(jwtToken.createToken(map, 1));
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE4Mjc1ODIzMDA3IiwiY2FwdGNoYSI6IjI4NTQ2NiIsImV4cFRpbWUiOiI1IiwiZXhwIjoxNzA5OTE0NjI3fQ.Hm3zzTV16tNmXBNDbCy8-s2KijhF-6BIezpAXMYQmKI";
        System.out.println(jwtToken.DecodedJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE4Mjc1ODIzMDA3IiwiY2FwdGNoYSI6IjM2MTA4MSIsImV4cFRpbWUiOiI1IiwiZXhwIjoxNzA5OTE2MzkwfQ.AerLCzYoEIBxvUeH5TsB9IzutGdHcS38ZwhlAo2rSXg", new String[]{"name", "age", "Address"}));
    }
}