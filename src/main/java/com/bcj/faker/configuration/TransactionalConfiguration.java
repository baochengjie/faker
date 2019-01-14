package com.bcj.faker.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

/**
 * @ClassName TransactionalConfiguration
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/14 14:38
 * @Version 1.0
 **/
@Configuration
public class TransactionalConfiguration {
    @Bean
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }
    @Bean
    public PlatformTransactionManager impalaTransactionManager(@Qualifier("impalaDataSource") DataSource impalaDataSource) {
        return new DataSourceTransactionManager(impalaDataSource);
    }
}
