package com.ins.anping.utils.OCRByBaiDu;


import com.baidu.aip.ocr.AipOcr;
import com.ins.anping.utils.File2ByteArray;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "你的 App ID";
    public static final String API_KEY = "你的 Api Key";
    public static final String SECRET_KEY = "你的 Secret Key";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


//        // 调用接口
//        String path = "test.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "true");


//        // 参数为本地图片路径
//        String image = "test.jpg";
//        JSONObject res = client.basicAccurateGeneral(image, options);
//        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = File2ByteArray.fileToBinArray(new File("E:\\fire2.jpg"));;
        JSONObject res = client.basicAccurateGeneral(file, options);
        System.out.println(res.toString(2));
    }
}