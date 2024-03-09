package com.ins.anping.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class File2ByteArray {
    public static byte[] fileToBinArray(File file){
        byte[] imageBytes = null;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            imageBytes = new byte[fileInputStream.available()];
            fileInputStream.read(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }
}
