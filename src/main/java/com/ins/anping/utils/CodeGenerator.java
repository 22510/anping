package com.ins.anping.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class CodeGenerator {

    public static void main(String[] args) {
        log.warn("!!!!是否要进行代码生成!!!!----已实现重要代码是否做好备份!!!!");
        log.warn("确认生成命令行输入 yes; 取消生成命令行输入 no");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("no")){
            log.warn("终止代码生成...");
            throw new RuntimeException("终止代码生成");
        }
        System.out.println("若要生成指定表, 请输入表名; 若全库生成, 直接回车; \n若生成指定多表, 请输入: {table1,table2...}");
        String tableName = scanner.nextLine();
        System.out.println("生成表{"+tableName+"}");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 项目根目录, 要注意, Win系统下和Linux系统下不一样
        String projectPath = System.getProperty("user.dir").replace("\\","\\\\");
//        String projectPath = "D:\\download\\music-website-master\\music-website-master\\demo";//代码生成地址
//        String packageName = CodeGenerator.class.getPackage().getName();
        // 代码生成器输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        // TODO: 公司名
        gc.setAuthor("INS");
        // 是否打开输出目录
        gc.setOpen(false);
        gc.setSwagger2(true);
        // 生成覆盖
        gc.setFileOverride(true);
        //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置: 注意修改数据库名字, 用户名密码
        DataSourceConfig dsc = new DataSourceConfig();
        // TODO: 真正上线和在其他开发环境要改
        dsc.setUrl("jdbc:mysql://localhost:3306/anping?serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Qh123456789!");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 修改这按模块生成
        pc.setModuleName("base");
        // 利用反射获取对应的包路径
        pc.setParent(CodeGenerator.class.getPackage().getName());
        mpg.setPackageInfo(pc);

        // 策略配置: 可以指定需要生成哪些表或者排除哪些表
        StrategyConfig strategy = new StrategyConfig();
        // 表名下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 属性名下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体是否为Lombok模型, 也就是一个@Data解决Getter/Setter和其他内容
        strategy.setEntityLombokModel(true);
        // 是否生成Restful风格的控制器, 就是前后端分离, Json传数据?
        strategy.setRestControllerStyle(true);
        // 需要包含的表名, enableSqlFilter为false时, 允许正则表达式
        System.out.println(tableName.isEmpty());
        if (tableName.isEmpty()){
            strategy.setInclude();
        }else {
            strategy.setInclude(tableName.split(","));
        }
        // 驼峰转连字符(用-连接单词)
        strategy.setControllerMappingHyphenStyle(true);
        // 去掉表前缀? 还是增加??? 但目前无影响
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        // 如果模板引擎是 velocity
        String templatePath = "/templates/controller.java.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "\\src\\main\\" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });
        log.info("MyBatisPlus代码逆向生成");
        mpg.execute();
        log.info("代码生成所在路径: CodeGenerator同级目录的<base>文件夹");
    }

}
