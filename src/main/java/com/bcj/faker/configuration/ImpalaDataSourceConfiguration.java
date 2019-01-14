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
 * @Title: ImpalaDataSourceConfiguration
 * @ProjectName: faker
 * @Description: 加载impala数据源
 * @author: baochengjie
 * @date: 2019/1/14 10:01
 */

@Configuration
@MapperScan(basePackages={"com.bcj.faker.mapper.impala"} ,
        sqlSessionFactoryRef="impalaSessionFactory")
public class ImpalaDataSourceConfiguration {

    private static final String MAPPER_LOCATIONS = "classpath:mappers/impala/*.xml";
    private static final String CONFIG_LOCATION = "classpath:mybatis-config.xml";

    @Autowired
    MySqlSessionFactory mySqlSessionFactory;

    /**
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "impalaSessionFactory")
    public SqlSessionFactory buildImpalaSessionFactory(@Qualifier(value = "impalaDataSource") DataSource dataSource) throws Exception{
        return mySqlSessionFactory.build(dataSource, MAPPER_LOCATIONS, CONFIG_LOCATION);
    }

    /**
     *
     * @return
     */
    @Bean(name = "impalaDataSource")
    @ConfigurationProperties(prefix="spring.datasource.impala")
    public DataSource buildImpalaDataSource(){
        return DataSourceBuilder.create().build();
    }

}
