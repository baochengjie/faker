package com.bcj.faker.scheduler;

import com.alibaba.fastjson.JSON;
import com.bcj.faker.model.CustomJobDetail;
import com.bcj.faker.service.MysqlJobService;
import com.bcj.faker.utils.ShellUtils;
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
    MysqlJobService mysqlCustomJobService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        int id = map.getInt("id");
        String commandDir = map.getString("command_dir");
        String commandParam = map.getString("command_param");
        String paramPrefix = map.getString("param_prefix");
        CustomJobDetail customJobDetail = new CustomJobDetail(commandDir,commandParam,paramPrefix);
        String schedule = map.getString("schedule");
        log.info("任务id为" + id + "正在执行脚本任务: "+JSON.toJSONString(map));
        try {
            String result = ShellUtils.callShell(customJobDetail);
            log.info("执行结果:"+result);
            mysqlCustomJobService.modifyJob(id);
        } catch (Exception e) {
            log.error("任务执行错误");
        }


    }
}
