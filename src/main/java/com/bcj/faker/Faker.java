package com.bcj.faker;

import com.bcj.faker.scheduler.MyScheduler;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {MybatisAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.bcj.faker.mapper"})
@EnableScheduling
public class Faker implements CommandLineRunner {
    @Autowired
    MyScheduler myScheduler;

    public static void main(String[] args) {
        SpringApplication.run(Faker.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myScheduler.getAllSchedulerJobs();
    }
}

