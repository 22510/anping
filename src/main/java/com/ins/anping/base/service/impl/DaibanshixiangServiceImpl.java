package com.ins.anping.base.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ins.anping.base.entity.Daibanshixiang;
import com.ins.anping.base.mapper.DaibanshixiangMapper;
import com.ins.anping.base.service.IDaibanshixiangService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author INS
 * @since 2024-03-14
 */
@Service
public class DaibanshixiangServiceImpl extends ServiceImpl<DaibanshixiangMapper, Daibanshixiang> implements IDaibanshixiangService {
    public Boolean add(Map<String, Object> map){
        Daibanshixiang daibanshixiang = BeanUtil.toBean(map, Daibanshixiang.class);
        return super.save(daibanshixiang);
    }
}
