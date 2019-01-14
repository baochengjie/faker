package com.bcj.faker.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Title: MySqlSessionFactory
 * @ProjectName: faker
 * @Description: TODO
 * @author: baochengjie
 * @date: 2019/1/14 10:01
 */
@Component
public class MySqlSessionFactory {

    /**
     *
     * @param dataSource 数据源
     * @param mapperConfiguration mapper xml文件
     * @param mybatisConfiguration mybatis config
     * @return SqlSessionFactory
     * @throws Exception
     */
    public SqlSessionFactory build(DataSource dataSource, String mapperConfiguration, String mybatisConfiguration) throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        //加载数据源
        sessionFactory.setDataSource(dataSource);
        //加载mapper xml文件
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperConfiguration));
        //加载mybatis xml文件
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource(mybatisConfiguration));

        return sessionFactory.getObject();
    }
}
