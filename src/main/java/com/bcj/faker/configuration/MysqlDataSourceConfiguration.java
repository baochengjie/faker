package com.bcj.faker.configuration;

import com.bcj.faker.utils.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Title: MySQLDataSourceConfiguration
 * @ProjectName: faker
 * @Description: 加载mysql数据源,因为是多数据源,所以需要手动加载。
 * 两步：第一步加载数据源,第二步加载mybatis配置
 * @author: baochengjie
 * @date: 2019/1/14 11:01
 */
@Configuration
@MapperScan( basePackages = {"com.bcj.faker.mapper.mysql"} ,
    sqlSessionFactoryRef = "mysqlSessionFactory")
public class MysqlDataSourceConfiguration {

    private static final String MAPPER_LOCATIONS = "classpath:mappers/mysql/*.xml";
    private static final String CONFIG_LOCATION = "classpath:mybatis-config.xml";

    @Autowired
    MySqlSessionFactory mySqlSessionFactory;

    /**
     * 构建SqlSessionFactory
     * @param dataSource 数据源,@Qualifier根据name注入
     * @return
     */
    @Bean(name = "mysqlSessionFactory")
    public SqlSessionFactory buildMySQLSessionFactory(@Qualifier(value = "mysqlDataSource") DataSource dataSource) throws Exception{
        return mySqlSessionFactory.build(dataSource, MAPPER_LOCATIONS, CONFIG_LOCATION);
    }

    /**
     * 加载mysql 数据源
     * @return DataSource
     */
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource loadMySQLDataSource(){
        return DataSourceBuilder.create().build();
    }
}
