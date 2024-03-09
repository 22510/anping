//package com.ins.anping.utils.OCRByBaiDu;
//
//import com.baidu.aip.imageclassify.AipImageClassify;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//
//public class BaiDuOCR {
//    //设置APPID/AK/SK
//    public static final String APP_ID = "55311020";
//    public static final String API_KEY = "Furrt6NuCeRVgvKPX06r14sU";
//    public static final String SECRET_KEY = "YCnXG11MMynNtb6KY4nvRWwPcJ1KYUJ8";
//
//    public static void main(String[] args) {
//        // 初始化一个AipImageClassify
//        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
////        // 调用接口
////        String path = "test.jpg";
////        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
////        System.out.println(res.toString(2));
//
//
//        // 参数为本地图片路径
//        String image = "test.jpg";
//        JSONObject res = client.basicAccurateGeneral(image, options);
//        System.out.println(res.toString(2));
//
//        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.basicAccurateGeneral(file, options);
//        System.out.println(res.toString(2));
//
//
//
//    }
//
//
//
//
//    /**
//     * 重要提示代码中所需工具类
//     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
//     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
//     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
//     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
//     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
//     * 下载
//     */
////    public static String accurateBasic() {
////        // 请求url
////        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
////        try {
////            // 本地文件路径
////            // 传入可选参数调用接口
////            HashMap<String, String> options = new HashMap<String, String>();
////            options.put("detect_direction", "true");
////            options.put("probability", "true");
////
////
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
//
////    public static void main(String[] args) {
//////        BaiDuOCR.accurateBasic();
////    }
//
//}
