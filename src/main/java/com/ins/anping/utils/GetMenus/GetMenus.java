package com.ins.anping.utils.GetMenus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Component
public class GetMenus {

    @Autowired
    private MokuaifenpeiServiceImpl mokuaifenpeiService;

    public List<Map<String, Object>> GetModules(Integer jueSeId){
//        Jueseguanli jueSeguanli = jueseguanliService.getById(jueSeId);
        QueryWrapper<Mokuaifenpei> mokuaifenpeiQueryWrapper = new QueryWrapper<>();
        mokuaifenpeiQueryWrapper.eq("JueSe", jueSeId.toString());
        List<Mokuaifenpei> mokuaifenpeis = mokuaifenpeiService.list(mokuaifenpeiQueryWrapper);
        HashSet<String> titleList = new HashSet<>();
        for(Mokuaifenpei m : mokuaifenpeis){
            String[] split = m.getMokuaiming().split(",");
            Collections.addAll(titleList, split);
        }
        System.out.println("菜单获取成功.");
        return GetMenuTools.GetMenus(String.valueOf(titleList));
    }


}
