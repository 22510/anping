package com.ins.anping.other;

import com.ins.anping.base.entity.Yonghuguanli;
import com.ins.anping.base.service.impl.YonghuguanliServiceImpl;
import com.ins.anping.utils.PasswordEncoder;
import com.ins.anping.utils.TimeUtils.MyTimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class LoginWebControllerTest {

    @Resource
    private YonghuguanliServiceImpl yonghuguanliService;
    @Test
    void makeUser() {
        String userName = "QeHing4";
        String password = "123456";
        String role = "15";
        String phone = "18275823010";
        String status = "yes";
        String leader = "yewuzhuguan";
        password = PasswordEncoder.encode("AnPingSys_" + password + "QeHing");
        Yonghuguanli yonghuguanli = new Yonghuguanli();
        yonghuguanli.setYonghuming(userName);
        yonghuguanli.setJuese(role);
        yonghuguanli.setShouji(phone);
        yonghuguanli.setYonghuzhuangtai(status);
        yonghuguanli.setMima(password);
        yonghuguanli.setLeader(leader);
        yonghuguanli.setZhuceshijian(MyTimeUtils.getNow());
        yonghuguanli.setInserttime(MyTimeUtils.getNow());
        yonghuguanliService.save(yonghuguanli);
    }
}