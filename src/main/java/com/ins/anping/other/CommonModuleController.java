package com.ins.anping.other;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import com.ins.anping.model.common.ResponseResult;
import com.ins.anping.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;


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
@RequestMapping(value = "/api/commonModule", produces = "application/json; charset=utf-8")
// produces 设置返回值类型, 另一个是 consumes, 指定处理请求的提交内容
public class CommonModuleController {
    @Autowired
    private MokuaifenpeiServiceImpl mokuaifenpeiService;

    // =============== 登录 =========================
    @GetMapping(value = "/getMenus")
    public ResponseResult<?> getMenus(){
        String JueSe = UserHolder.getUser().getJueSe();
        QueryWrapper<Mokuaifenpei> mokuaifenpeiQueryWrapper = new QueryWrapper<>();
        List<Mokuaifenpei> jueSeMokuais = mokuaifenpeiService.list(mokuaifenpeiQueryWrapper.eq("JueSe", JueSe));
        if (jueSeMokuais.isEmpty()){
            throw new RuntimeException("角色获取失败");
        }
        return ResponseResult.okResult(200, "操作成功", jueSeMokuais);
    }

    private static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
