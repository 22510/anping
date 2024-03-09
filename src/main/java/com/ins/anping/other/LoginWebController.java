package com.ins.anping.other;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.entity.Yonghuguanli;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import com.ins.anping.base.service.impl.YonghuguanliServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.JwtToken;
import com.ins.anping.utils.PasswordEncoder;
import com.ins.anping.utils.SMSApi.SendMessageTencent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.ins.anping.utils.someConstant.USER_TOKEN_EXPTIME;


/**
 * TODO: 推荐使用电话登录, 注册时要检测电话是否存在...
 *
 */

/**
 * 执行ng命令，建立相应的模块和组件
 * @author cmx
 *
 */
@Slf4j
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/loginModule", produces = "application/json; charset=utf-8")
// produces 设置返回值类型, 另一个是 consumes, 指定处理请求的提交内容
public class LoginWebController {

    @Autowired
    private JwtToken jwtToken;

    // =============== 登录 =========================
    @PostMapping(value = "/login")
    public ResponseResult<?> getLogin(@RequestBody Map<String, String> map) throws Exception {
        return getLoginInfo(map);
    }

    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody Map<String, String> map) throws Exception {
//        String YongHuMing = map.get("yonghuming");
        String ShouJi = map.get("shouji");
//        String JueSe = map.get("juese");
        String MiMa = map.get("mima");
        String captcha = map.get("captcha");
        String captchaToken = map.get("captchaToken");
        if (captchaToken == null){
            throw new RuntimeException("验证码token为空");
        }
        log.info(captchaToken);
        Map<String, Object> captchaContent = jwtToken.DecodedJWT(captchaToken, new String[]{"phone", "captcha", "expTime"});
        log.info(captchaContent.toString());
        if (-1 == Integer.parseInt(captchaContent.get("code").toString())){
            return ResponseResult.errorResult(500, "验证码已过期");
        }

        if (!ShouJi.equals(captchaContent.get("phone"))){
            throw new RuntimeException("手机号错误");
        }
        if (5 > Integer.parseInt(captchaContent.get("expTime").toString())){
            return ResponseResult.errorResult(500, "验证码已过期");
        }
        System.out.println("验证码过期?");
        if (!captcha.equals(captchaContent.get("captcha"))){
            return ResponseResult.errorResult(500, "验证码错误");
        }
        System.out.println("验证码失效?");
        QueryWrapper<Yonghuguanli> yonghuguanliQueryWrapper = new QueryWrapper<>();
        yonghuguanliQueryWrapper.eq("ShouJi", ShouJi);
        // TODO: 如果一个系统中, 有两个人名字相同, 那如何处理...
        if (yonghuguanliService.getOne(yonghuguanliQueryWrapper) != null){
            return ResponseResult.errorResult(500, "账号已经存在");
        }
        System.out.println("准备保存用户");
        new Yonghuguanli();
        Yonghuguanli userDetail;
        map.remove("captcha");
        map.remove("captchaToken");
        map.put("mima", PasswordEncoder.encode("AnPingSys_"+MiMa+"QeHing"));
        map.put("yonghuzhuangtai", "no");
        map.put("zhuceshijian", Calendar.getInstance().getTime().toString());
        map.put("juese", String.valueOf(8));
        map.put("inserttime", Calendar.getInstance().getTime().toString());
        userDetail = BeanUtil.toBean(map, Yonghuguanli.class);
        System.out.println(userDetail.toString());
        if (!yonghuguanliService.save(userDetail)){
            return ResponseResult.errorResult(500, "系统错误, 请联系管理员");
        }
        return ResponseResult.okResult(200, "注册成功, 请稍后登录", null);
    }

    @GetMapping("/captcha/{phone}")
    public ResponseResult<?> getCaptcha(@PathVariable("phone") String phone) throws Exception {
        log.warn("getCaptcha:"+phone);
        String captcha = SendMessageTencent.sendCaptcha(phone, "5");
        if (captcha == null){
            throw new RuntimeException("验证码发送失败");
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("phone", phone);
        returnMap.put("captcha", captcha);
        returnMap.put("expTime", 5);
        String captchaToken =  jwtToken.createToken(returnMap, 10);
        System.out.println(captchaToken);
        return ResponseResult.okResult(200, "验证码发送成功", captchaToken);
    }

    @Autowired
    private YonghuguanliServiceImpl yonghuguanliService;

    @Autowired
    private MokuaifenpeiServiceImpl mokuaifenpeiService;

    private ResponseResult<?> getLoginInfo(Map<String, String> map) throws Exception {
        // 这里map里只存有用户名和密码
        String userName = map.get("username");
        String password = map.get("password");
        // TODO: 假设输入的是工号，用来登录。

        QueryWrapper<Yonghuguanli> wrapper = new QueryWrapper<>();
        // 1. 假设输入的是电话号码
        if (isInteger(userName)){
            wrapper.eq("ShouJi", userName);
        }else{
            wrapper.eq("YongHuMing", userName);
        }
        Yonghuguanli userDetail = yonghuguanliService.getOne(wrapper);
        System.out.println(userDetail.toString());
        if (userDetail == null){
            wrapper.eq("", userName);
        }

        if (userDetail == null){
            log.warn("用户{"+userName+"}没注册并尝试登录");
            return ResponseResult.errorResult(500, "用户不存在");
        }
        if (!PasswordEncoder.matches(userDetail.getMima(),"AnPingSys_"+password+"QeHing")){
            log.warn("用户{"+userName+"}尝试登录密码错误");
            return ResponseResult.errorResult(500, "登录密码错误");
        }
        // 这里, 用户状态我不知道是不是指用户的账号状态...
        if (userDetail.getYonghuzhuangtai().equals("no")){
            return ResponseResult.errorResult(500, "当前账号不可用, 请联系管理员或稍后尝试登录");
        }

        // 用户注册, 管理员审批, 给用户分配角色, 或者用户注册时选择身份, 管理员核实通过
        // 这里应该检测的是用户状态, 0未通过, 1通过
        // 拿角色信息
        QueryWrapper<Mokuaifenpei> mokuaifenpeiQueryWrapper = new QueryWrapper<>();
        // TODO: 这里需要获取角色菜单
//        List<Mokuaifenpei> jueSeMokuais = mokuaifenpeiService.list(mokuaifenpeiQueryWrapper.eq("JueSe", userDetail.getJuese()));

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", userName);
        userMap.put("JueSe", userDetail.getJuese());
        Map<String, Object> retmap = new HashMap<>();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("yonghuming", userDetail.getYonghuming());
        userInfo.put("juese", userDetail.getJuese());
//        userInfo.put("module", jueSeMokuais);
        retmap.put("token", jwtToken.createToken(userMap, USER_TOKEN_EXPTIME));
        retmap.put("userInfo", userInfo);
        log.info(retmap.toString());
        return ResponseResult.okResult(200, "登录成功", retmap);
    }

    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
