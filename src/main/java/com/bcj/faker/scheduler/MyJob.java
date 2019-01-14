package com.bcj.faker.scheduler;

import com.bcj.faker.service.MysqlCustomJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MyJob
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/14 11:07
 * @Version 1.0
 **/
@Slf4j
public class MyJob implements Job {
    @Autowired
    MysqlCustomJobService mysqlCustomJobService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        int id = map.getInt("id");
        String schedule = map.getString("schedule");
        //log.info("MyJob execute... ");
        log.info("任务id为" + id + "正在执行任务：");
        try {
            mysqlCustomJobService.modifyJob(id);
        } catch (Exception e) {
            log.error("任务执行错误");
        }


    }
}
