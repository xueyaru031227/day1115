package com.lening.day1001.uilts;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author 段鑫
 * @version 1.0
 * @data 2022/9/17 16:27
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("000000");
        dataSourceConfig.setUrl("jdbc:mysql:///day1001");
        autoGenerator.setDataSource(dataSourceConfig);

        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir("D:\\Java\\springboot\\代码");//设置代码生成位置
        globalConfig.setOpen(true);//设置代码生成后是否自动打开生成位置
        globalConfig.setAuthor("段鑫（乐柠教育）");//设置作者名称
        globalConfig.setFileOverride(true);//设置是否覆盖原始生成文件
        globalConfig.setMapperName("%sMapper");//设置数据层接口名，%s为占位符，指代模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID);//设置id生成策略 （主键返回）
        globalConfig.setSwagger2(true);//开启Swagger2模式
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名相关的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.lening");//设置父包名
        packageConfig.setEntity("bean");//设置实体类包名
        packageConfig.setMapper("mapper");//设置数据层接口包名
        autoGenerator.setPackageInfo(packageConfig);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        //  strategyConfig.setInclude("t_permethod");//设置参与生成的表名
        strategyConfig.setTablePrefix("tb_");//设置数据库表的前缀名称 模块名 = 表名-前缀名称
        strategyConfig.setRestControllerStyle(true);//设置是否为rest风格
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略：下划线连转驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//// 表字段生成策略：下划线连转驼峰
        //  strategyConfig.setVersionFieldName("version");//设置乐观锁字段名
        //  strategyConfig.setLogicDeleteFieldName("deleted");//设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true);//设置是否启用lombok
        autoGenerator.setStrategy(strategyConfig);

        //执行
        autoGenerator.execute();

    }
}
