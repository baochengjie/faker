package com.bcj.faker.scheduler;

import com.bcj.faker.model.CustomJob;
import com.bcj.faker.service.MysqlCustomJobService;
import com.bcj.faker.utils.HandleUtils;
import com.bcj.faker.utils.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: SchedulerJobs
 * @ProjectName: faker
 * @Description: TODO
 * @author: baochengjie
 * @date: 2019/1/14 12:07
 */
@Slf4j
@Component
public class MyScheduler {

    @Autowired
    MysqlCustomJobService mysqlCustomJobService;

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;
    
    /* *
     * @Description: 程序启动时从数据库读取数据,创建定时任务
     * @param
     * @return
     * @throws
     * @author baochengjie
     */
    public void getAllSchedulerJobs() {
        List<CustomJob> customJobList = mysqlCustomJobService.getCronSchedulerJobs();
        customJobList.stream().forEach(value -> {
            addJob(value);
        });
    }

    /* *
     * @Description: 添加定时任务
     * @param [customJob]
     * @return
     * @throws
     * @author baochengjie
     */
    public void addJob(CustomJob customJob) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        //任务信息
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).
                usingJobData("id", customJob.getId()).
                usingJobData("jobCommand", customJob.getJobCommand()).
                usingJobData("schedule", customJob.getSchedule()).
                withIdentity(customJob.getId().toString()).
                withDescription(customJob.getJobName()).
                build();
        String crontab = customJob.getScheduleCrontab();
        if ("0".equals(customJob.getSchedule())) {
            crontab = HandleUtils.getCron(customJob.getScheduleCrontab());
        }
        log.info(customJob.getJobName() + " crontab " + crontab);
        //定时计划
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(crontab);
        //创建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().
                withIdentity(customJob.getId().toString()).
                withSchedule(cronScheduleBuilder).build();
        try {
            //创建定时任务
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            log.error("addJob 定时任务创建错误 ", e);
        }
    }

    /* *
     * @Description: 删除定时任务
     * @param [id]
     * @return
     * @throws
     * @author xiaobingxian
     * @date 2018/10/16
     */
    public void deleteJob(int id) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(String.valueOf(id));
        try {
            //停止触发器
            scheduler.pauseTrigger(triggerKey);
            //删除触发器
            scheduler.unscheduleJob(triggerKey);
            //删除任务
            JobKey jobKey = JobKey.jobKey(String.valueOf(id));
            scheduler.deleteJob(jobKey);
            log.info("deleteJob 删除定时任务 id=" + id + " jobKey=" + jobKey);
        } catch (SchedulerException e) {
            log.error("deleteJob 删除定时任务错误 ", e);
        }
    }

    /* *
     * @Description: 修改定时任务
     * @param [CustomJob customJob, String cronExpression]
     * @return
     * @throws
     * @author xiaobingxian
     * @date 2018/10/16
     */
    public void updateJob(CustomJob customJob, String cronExpression) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(TriggerKey.triggerKey(customJob.getId().toString()));
            if (cronTrigger != null && !cronTrigger.getCronExpression().equals(cronExpression)) {
                deleteJob(customJob.getId());
//                addJob(customJob);
                JobDetail jobDetail = JobBuilder.newJob(MyJob.class).
                        usingJobData("id", customJob.getId()).
                        usingJobData("jobCommand", customJob.getJobCommand()).
                        usingJobData("schedule", customJob.getSchedule()).
                        withIdentity(customJob.getId().toString()).
                        withDescription(customJob.getJobName()).
                        build();
                String crontab = Constant.CRONTAB;
                if ("0".equals(customJob.getSchedule())) {
                    crontab = HandleUtils.getCron(customJob.getScheduleCrontab());
                }
                log.info(customJob.getJobName() + " crontab " + crontab);
                //定时计划
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(crontab);
                //创建触发器
                cronTrigger = TriggerBuilder.newTrigger().
                        withIdentity(customJob.getId().toString()).
                        withSchedule(cronScheduleBuilder).build();
                try {
                    //创建定时任务
                    scheduler.scheduleJob(jobDetail, cronTrigger);
                    log.info("addJob 新增定时任务 jobId="+customJob.getId()+" cron=" + cronExpression);
                } catch (SchedulerException e) {
                    log.error("addJob 定时任务创建错误 ", e);
                }
            }
        } catch (SchedulerException e) {
            log.error("updateJob 更新定时任务 ", e);
        }

    }

}
