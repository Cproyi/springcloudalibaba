package com.huangyuan.helperpro.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisPlusGenerator {
    //要生成的表名
    public static String[] genTablesName= new String[]{
            "t_role"
    };
    public static void runMybatisPlusGenerator() {
        AutoGenerator autoGenerator = new AutoGenerator();
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir("D:\\java");
        config.setFileOverride(true);
        config.setActiveRecord(true);
        config.setEnableCache(false);// XML 二级缓存
        config.setBaseResultMap(true);// XML ResultMap
        config.setBaseColumnList(false);// XML columList
        config.setAuthor("huangyuan");
        config.setOpen(false);
        // 自定义文件命名,注意 %s 会自动填充表实体属性!
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");
        autoGenerator.setGlobalConfig(config);
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/alibaba_user?serverTimezone=UTC&" +
                "useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&" +
                "useSSL=false&allowPublicKeyRetrieval=true");
        autoGenerator.setDataSource(dataSourceConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix("bmd_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(genTablesName); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 字段名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.maxbill.base.SuperModel");
        // 自定义实体,公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.maxbill.base.SuperMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.maxbill.base.SuperService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.maxbill.base.SuperServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.maxbill.base.SuperController");
        // 【实体】是否生成字段常量(默认 false)
        // public static final String ID = "test_id";
        strategy.setEntityColumnConstant(false);
        // 【实体】是否为构建者模型(默认 false)
        // public User setName(String name) {this.name = name; return this;}
        strategy.setEntityBuilderModel(true);
        autoGenerator.setStrategy(strategy);
        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.huangyuan.userservice.modules.user");
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper");
        // packageConfig.setModuleName("base");
        autoGenerator.setPackageInfo(packageConfig);
        // 注入自定义配置,可以在 VM 中使用 cfg.abc 设置的值
		/*InjectionConfig injectionConfig = new InjectionConfig() {
			@Override
			public void initMap() {
				Map map = new HashMap();
				map.put("maxbill", this.getConfig().getGlobalConfig().getAuthor() + "-MybatisPlus");
				this.setMap(map);
			}
		};
		autoGenerator.setCfg(injectionConfig);*/
        // 执行生成
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
        // 打印注入设置
        //System.err.println(autoGenerator.getCfg().getMap().get("maxbill"));
    }

    public static void main(String[] args) {
        runMybatisPlusGenerator();
        //System.out.println(LocalDateTime.now());
    }
}