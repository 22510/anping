package com.ins.anping.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ins.anping.utils.GetMenus.GetMenus;
import com.ins.anping.utils.GetMenus.MenuItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetMenusTest {

    @Autowired
    private GetMenus getMenus;

    @Test
    void getModules() throws JsonProcessingException {
//        getMenus.GetModules(1);
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("测试JueSeId=8");
        HashSet<String> titleList = getMenus.GetModules(8);
        String jsonInput = "[\n" +
                "    {\n" +
                "        \"icontype\": \"outline\",\n" +
                "        \"subIndex\": 0,\n" +
                "        \"level\": 1,\n" +
                "        \"icon\": \"star\",\n" +
                "        \"mainIndex\": 0,\n" +
                "        \"index\": \"99\",\n" +
                "        \"title\": \"基础数据维护\",\n" +
                "        \"type\": \"table\",\n" +
                "        \"isLeaf\": true,\n" +
                "        \"children\": [\n" +
        "                    {\n" +
        "                        \"icontype\": \"fill\",\n" +
        "                        \"subIndex\": 0,\n" +
        "                        \"level\": 1,\n" +
        "                        \"icon\": \"dribbble-square\",\n" +
        "                        \"mainIndex\": 0,\n" +
        "                        \"index\": 0,\n" +
        "                        \"title\": \"业务员\",\n" +
        "                        \"type\": \"homepage\",\n" +
        "                        \"isLeaf\": true,\n" +
        "                        \"nodeInfo\": {\n" +
        "                            \"isLeaf\": true\n" +
        "                        },\n" +
        "                        \"config\": \"homepage-config\",\n" +
        "                        \"key\": \"YeWuYuan\",\n" +
        "                        \"selected\": false,\n" +
        "                        \"iconcolor\": \"#888800\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"icontype\": \"twotone\",\n" +
        "                        \"subIndex\": 1,\n" +
        "                        \"level\": 1,\n" +
        "                        \"icon\": \"project\",\n" +
        "                        \"mainIndex\": 0,\n" +
        "                        \"index\": 0,\n" +
        "                        \"title\": \"业务经理\",\n" +
        "                        \"type\": \"homepage\",\n" +
        "                        \"isLeaf\": true,\n" +
        "                        \"nodeInfo\": {\n" +
        "                            \"isLeaf\": true\n" +
        "                        },\n" +
        "                        \"config\": \"homepage-config\",\n" +
        "                        \"key\": \"YeWuJingLi\",\n" +
        "                        \"selected\": false,\n" +
        "                        \"iconcolor\": \"#003377\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"icontype\": \"outline\",\n" +
        "                        \"subIndex\": 2,\n" +
        "                        \"level\": 1,\n" +
        "                        \"icon\": \"taobao-circle\",\n" +
        "                        \"mainIndex\": 0,\n" +
        "                        \"index\": 0,\n" +
        "                        \"title\": \"收发人员\",\n" +
        "                        \"type\": \"homepage\",\n" +
        "                        \"isLeaf\": true,\n" +
        "                        \"nodeInfo\": {\n" +
        "                            \"isLeaf\": true\n" +
        "                        },\n" +
        "                        \"config\": \"homepage-config\",\n" +
        "                        \"key\": \"ShouFaRenYuan\",\n" +
        "                        \"selected\": false,\n" +
        "                        \"iconcolor\": \"#7A0099\"\n" +
        "                    }\n" +
                "        \"nodeInfo\": {\n" +
                "            \"isLeaf\": true\n" +
                "        },\n" +
                "        \"config\": \"editconfig\",\n" +
                "        \"key\": \"JiChuShuJuWeiHu\",\n" +
                "        \"selected\": false,\n" +
                "        \"iconcolor\": \"#00AA88\"\t\t\n" +
                "\t}\n" +
                "]";
        List<MenuItem> menuItems = objectMapper.readValue(jsonInput, new TypeReference<List<MenuItem>>(){});
        System.out.println(menuItems.toString());
    }

}