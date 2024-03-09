package com.ins.anping.utils.GetMenus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ins.anping.base.entity.Jueseguanli;
import com.ins.anping.base.entity.Mokuaifenpei;
import com.ins.anping.base.service.impl.JueseguanliServiceImpl;
import com.ins.anping.base.service.impl.MokuaifenpeiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
public class GetMenus {

    @Autowired
    private JueseguanliServiceImpl jueseguanliService;

    @Autowired
    private MokuaifenpeiServiceImpl mokuaifenpeiService;

    public HashSet<String> GetModules(Integer jueSeId){
        Jueseguanli jueSeguanli = jueseguanliService.getById(jueSeId);
        System.out.println(jueSeguanli.toString());
        QueryWrapper<Mokuaifenpei> mokuaifenpeiQueryWrapper = new QueryWrapper<>();
        mokuaifenpeiQueryWrapper.eq("JueSe", jueSeId);
        List<Mokuaifenpei> mokuaifenpeis = mokuaifenpeiService.list(mokuaifenpeiQueryWrapper);
        HashSet<String> titleList = new HashSet<>();
        for(Mokuaifenpei m : mokuaifenpeis){
            System.out.println(m.toString());
            String[] split = m.getMokuaiming().split(",");
            Collections.addAll(titleList, split);
        }
        System.out.println(titleList);
        return titleList;


/* 取出来的数据长这样
Jueseguanli(id=8, juese=业务员, zhongyaoxing=, beizhu=, username=cmxadmin, inserttime=2023-12-12 22:36:41, updatetime=null)
Mokuaifenpei(id=4, juese=8, gongnengliebiao=添加,修改,删除,导出Excel, mokuaiming=发起租赁发货,租赁合同, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=5, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=6, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=11, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=12, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=21, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=30, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=,物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询
, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=39, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=业务员, beizhu=null, username=null, inserttime=null, updatetime=null)
Mokuaifenpei(id=50, juese=8, gongnengliebiao=添加,修改,删除, mokuaiming=付款节点, beizhu=null, username=null, inserttime=null, updatetime=null)
 */

//        List<Mokuaifenpei> mokuaifenpeis = new ArrayList<>();
//        mokuaifenpeis.add(new Mokuaifenpei(4L,"8","添加,修改,删除,导出Excel","发起租赁发货,租赁合同",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(5L,"8","添加,修改,删除","物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(6L,"8","添加,修改,删除","物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(21L,"8","添加,修改,删除","物料汇总,ZLU杠,方管,插销,钩子螺母销片,方柱扣,钢背楞,梁卡具,锁具,角横梁外套,租赁合同,发货信息查询,库房备货查询,库房发货查询,租赁合同物料,租赁结算,租赁清算,退货员清点货物,库房收到退货,退货信息查询",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(30L,"8","添加,修改,删除",",物料汇总,物料库存一览图,租赁合同,租赁合同物料,发起租赁发货,发货信息查询,发起租赁退货,退货信息查询,库房备货历史数据查询,库房发货查询,库房退货信息查询,销售合同,销售合同物料,销售发起发货,销售发货信息查询,销售发起退货,销售发起退货信息查询,销售库房备货历史查询,销售库房发货查询,销售库房退货查询,转租合同,转租合同物料,转租业务员发起收货信息查询,转租业务员发起退回信息查询,转租物料入库历史查询,转租退回物料历史查询",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(39L,"8","添加,修改,删除","业务员",null,null,null,null));
//        mokuaifenpeis.add(new Mokuaifenpei(50L,"8","添加,修改,删除","付款节点",null,null,null,null));


    }


}
