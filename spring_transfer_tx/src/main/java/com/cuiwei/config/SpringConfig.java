package com.cuiwei.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //声明该类为核心配置类
@ComponentScan("com.cuiwei")   //包扫描
@Import(DataSourceConfig.class)  //导入其他配置类
@EnableTransactionManagement
public class SpringConfig {


    @Bean
    public JdbcTemplate getJdbcTemplate(@Autowired  DataSource dataSource){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


    @Bean
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource){

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);

        return  dataSourceTransactionManager;

    }



}
