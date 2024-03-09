package com.ins.anping.utils.OCRByBaiDu;

import java.net.URLEncoder;

/**
 * 办公文档识别
 */
public class AnalysisOffice {

    public static String analysisOffice() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/doc_analysis_office";
        try {
            // 本地文件路径
            String filePath = "E:\\jibenxinxi2.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            return HttpUtil.post(url, accessToken, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(AnalysisOffice.analysisOffice());
    }
}