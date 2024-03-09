package com.ins.anping.utils.fileSave;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class SaveLocal {
//
//    /**
//     * 文件存储服务器本地上
//     * @param files 文件列表
//     * @param localSavePath 存储路径: 要注意, 不同系统的存储路径不一样. win是"//", linux是"\"
//     * @return 返回文件名与对应的存储连接.
//     */
//    public static Map<String, String> saveFileLocal(List<MultipartFile> files, String localSavePath) throws IOException {
//        Map<String, String> fileUrls = new HashMap<>();
//        if (files.isEmpty()){
//            throw new RuntimeException("no file");
//        }
//        // TODO: Linux部署要修改
//        String savePath = System.getProperty("user.dir").replace("\\","\\\\") + "\\\\" +localSavePath;
//        System.out.println("保存路径:"+savePath);
//        File dir = new File(savePath);
//        if(!dir.exists()){
//            dir.mkdir();
//            log.info("创建目录:"+savePath);
//        }
//        for (MultipartFile file : files){
//            String fileName = file.getOriginalFilename();
//            String filePath = savePath + File.separator + fileName;
//            System.out.println("路径:"+filePath);
////            File targetFile = new File(filePath);
////            String fileType = file.getContentType();
////            File fileSave = new File(Objects.requireNonNull(fileName));
////            try(FileOutputStream fos = new FileOutputStream(fileSave)){
////                fos.write(file.getBytes());
////            } catch (IOException e) {
////                throw new RuntimeException(e);
////            }
////            File saveDirectory = new File(savePath);
////            if (!saveDirectory.exists()){
////                boolean mkdir = saveDirectory.mkdirs();
////                if (!mkdir){
////                    throw new RuntimeException();
////                }
////            }
//            file.transferTo(new File(filePath));
//            String basePath = "E:\\Coding\\Java\\anping\\ZuLinHeTongGuanli";
////            FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
////            .substring(basePath.length())
//            fileUrls.put(fileName, filePath.replace("\\\\", "\\"));
//        }
//        return fileUrls;
//    }


    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMM");


    /**
     * 文件存储服务器本地上
     * @param files 文件列表
     * @return 返回文件名与对应的存储连接.
     */
    public static Map<String, String> saveFileLocal(List<MultipartFile> files, String ContractNum) throws IOException {
        Map<String, String> fileUrls = new HashMap<>();
        if (files.isEmpty()){
            throw new RuntimeException("no file");
        }
        // TODO: Linux部署要修改
        for (MultipartFile file : files){
            //
            String[] fileNameAndPath = storeFile(file, ContractNum);
            fileUrls.put(fileNameAndPath[0],fileNameAndPath[1]);
        }
        return fileUrls;
    }

    // 返回值第一个值是文件名，第二个是文件保存路径
    private static String[] storeFile(MultipartFile file, String ContractNum) throws IOException {
        String yearMonth = SDF.format(new Date());//当前年月
        //String random = "" + (int) (Math.random() * 1000);//随机4位数,没补0
        String fileName = file.getOriginalFilename();//文件全名
        // String suffix = suffix(fileName);//文件后缀
        String relPath = "/" + ContractNum +"/" + fileName;
        String toPath = "./ZuLinHeTongGuanli" + relPath;
        log.info("文件的存储路径{}",toPath);
        FileOutputStream out = null;
        File toFile = new File(toPath).getParentFile();
        if (!toFile.exists()) {
            toFile.mkdirs(); //自动创建目录
        }
        try {
            out = new FileOutputStream(toPath);
            out.write(file.getBytes());
            out.flush();
            log.info(relPath);
            log.info(fileName);
            return new String[]{fileName,relPath};
        } catch (FileNotFoundException fnfe) {
            throw fnfe;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    private static String suffix(String fileName) {
        int i = fileName.lastIndexOf('.');
        return i == -1 ? "" : fileName.substring(i);
    }
}
