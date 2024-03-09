package com.ins.anping.utils.OCRByBaiDu;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.net.URLEncoder;

/**
 * 通用文字识别（高精度版）
 */
@Slf4j
@Component
public class AccurateBasic {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */

    public static String accurateBasic(byte[] bytes) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
        try {
            // 本地文件路径
//            String filePath = "E:\\jibenxinxi2.png";
//            byte[] imgData = FileUtil.readFileByBytes(filePath);
            // 出租单位/出租方, 承租单位/承租方, 项目名称/工程名称, 项目地址/工程地址, 承租方开户行/甲方开户银行, 接收人/出租方指定租赁物签收人?, 物料运费???
            String imgStr = Base64Util.encode(bytes);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            //            log.warn(result);
            return HttpUtil.post(url, accessToken, param);
        } catch (Exception e) {
            log.warn("catch exception:{}", e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        AccurateBasic.accurateBasic(null);
    }
}