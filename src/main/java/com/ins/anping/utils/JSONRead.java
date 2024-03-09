package com.ins.anping.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Component
public class JSONRead {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, String> readJsonFileToMap(String filePath) {
        try {
            File file = new ClassPathResource(filePath).getFile();
            return objectMapper.readValue(file,new TypeReference<Map<String,String>>(){});
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file to map", e);
        }
    }

    public static void main(String[] args) {
        Map<String, String> data = readJsonFileToMap("test.json");
        System.out.println(data);
    }
}
