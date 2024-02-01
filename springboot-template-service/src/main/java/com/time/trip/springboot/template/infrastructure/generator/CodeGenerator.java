package com.time.trip.springboot.template.infrastructure.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.time.trip.mybatisplus.infrastructure.BaseEntity;
import com.time.trip.springboot.template.infrastructure.BaseDO;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    public static void main(String[] args) {
        // 初始化数据源
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        // 全局配置
        generator.global(globalConfig().build());
        // 包配置
        generator.packageInfo(packageConfig().build());
        // 模板配置
        generator.template(templateConfig().build());
        // 注入配置
        generator.injection(injectionConfig().build());
        // 策略配置
        generator.strategy(strategyConfig().build());
        generator.execute();
    }

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/mybatis_plus", "root", "123456")
            .build();

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        return new GlobalConfig.Builder()
                // 禁止打开输出目录，一般不需要打开
                .disableOpenDir()
                // 指定输出目录，通过 `System.getProperty("user.dir")` 获取当前工程绝对路径，然后再指定到 Source 目录即可。具体的包路径由包配置定义
                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                // 作者名，一般使用公司简称
                .author("trip")
                // 开启 kotlin 模式
//                .enableKotlin()
                // 开启 swagger 模式，entity一般无需 swagger 注释
//                .enableSwagger()
                // 时间策略(ONLY_DATE: 只使用 java.util.date 代替, SQL_PACK: 使用 java.sql 包下的, TIME_PACK: 使用 java.time 包下的)
                // 默认 TIME_PACK，一般使用 TIME_PACK(java8 新的时间类型，LocalDateTime 等类型)
                .dateType(DateType.TIME_PACK)
                // 注释日期
                .commentDate("yyyy-MM-dd")
                ;
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        return new PackageConfig.Builder()
                // 父包名
                .parent("com.time.trip.mybatisplus")
                // Entity包名，entity、mapper一般放在infrastructure层或do层
                .entity("infrastructure.entity")
                // Service 包名
                .service("service")
                // Service Impl 包名
                .serviceImpl("service.impl")
                // Mapper 包名
                .mapper("infrastructure.mapper")
                // Mapper XML 包名，一般我会选择不生成，对应有自定义sql的需求，就以Ext的命名形式在resources目录下定义
//                .xml("infrastructure.mapper.xml")
                // Controller 包名
                .controller("controller")
                ;
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder()
                // 禁用XML模版，即不生成xml文件
                .disable(TemplateType.XML)
                ;
    }

    /**
     * 注入配置
     */
    protected static InjectionConfig.Builder injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        });
    }

    /**
     * 策略配置
     */
    protected static StrategyConfig.Builder strategyConfig() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder()
                // 增加过滤表前缀
                .addTablePrefix("m_", "s_", "op_", "f_", "d_", "n_", "a_", "b_", "hn_", "hb_", "r_", "t_")
                .addInclude(getTables(scanner()));
        // Entity 策略配置
        builder.entityBuilder()
                // 开启 lombok 模型
                .enableLombok()
                // 数据库表映射到实体的命名策略，默认下划线转驼峰命名
                .naming(NamingStrategy.underline_to_camel)
                // 格式化文件名称
                .formatFileName("%sDO")
                // 设置父类，将公共字段抽象到父类中
                .superClass(BaseDO.class)
                // 添加父类公共字段
                .addSuperEntityColumns("id", "gmt_create", "create_id", "gmt_modify", "modify_id", "is_deleted")
                // 覆盖已生成文件，一般entity选择覆盖，及时更新新增/变更的字段
                .enableFileOverride()
        ;
        return builder;
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名，多个英文逗号分隔？所有输入 all");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        return "";
    }

}
