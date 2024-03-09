package com.ins.anping.utils.fileSave;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveLocal {

    /**
     * 文件存储服务器本地上
     * @param files 文件列表
     * @param localSavePath 存储路径: 要注意, 不同系统的存储路径不一样. win是"//", linux是"\"
     * @return 返回文件名与对应的存储连接.
     */
    public static Map<String, String> saveFileLocal(List<MultipartFile> files, String localSavePath) throws IOException {
        Map<String, String> fileUrls = new HashMap<>();
        if (files.isEmpty()){
            throw new RuntimeException("no file");
        }
        // TODO: Linux部署要修改
        String savePath = System.getProperty("user.dir").replace("\\","\\\\") + localSavePath;
        System.out.println("保存路径:"+savePath);
        for (MultipartFile file : files){
            String fileName = file.getOriginalFilename();
//            String fileType = file.getContentType();
//            File fileSave = new File(Objects.requireNonNull(fileName));
//            try(FileOutputStream fos = new FileOutputStream(fileSave)){
//                fos.write(file.getBytes());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            File saveDirectory = new File(savePath);
//            if (!saveDirectory.exists()){
//                boolean mkdir = saveDirectory.mkdirs();
//                if (!mkdir){
//                    throw new RuntimeException();
//                }
//            }
            String filePath = savePath + File.separator + fileName;
            file.transferTo(new File(filePath));
            String basePath = "E:\\Coding\\Java\\anping\\ZuLinHeTongGuanli";
            fileUrls.put(fileName, filePath.replace("\\\\", "\\").substring(basePath.length()));
        }
        return fileUrls;
    }
}
