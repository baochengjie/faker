package com.bcj.faker.controller;

import com.bcj.faker.dto.JobMessage;
import com.bcj.faker.model.CustomJob;
import com.bcj.faker.scheduler.MyScheduler;
import com.bcj.faker.service.MysqlJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CustomJobController
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/14 15:16
 * @Version 1.0
 **/
@CrossOrigin("*")
@RestController
@RequestMapping("/faker")
@Api(description = "程序管理控制器")
public class CustomJobController {
    @Autowired
    private MysqlJobService mysqlCustomJobService;
    @Autowired
    private MyScheduler myScheduler;
    //region 添加一个程序信息
    @ApiOperation(value = "创建一个新的program", notes = "注册一个新的程序")
    @PostMapping("/add_job")
    @ResponseBody
    public Object addJob(@RequestBody JobMessage jobMessage){
        JobMessage jobMessage1 = mysqlCustomJobService.insertJob(jobMessage);
        myScheduler.addJob(jobMessage1);
        System.out.println(jobMessage);
        return jobMessage;
    }
    @ApiOperation(value = "更改定时任务", notes = "修改定时任务")
    @PostMapping("/update_job")
    @ResponseBody
    public Object updateJob(@RequestBody JobMessage jobMessage){
        myScheduler.updateJob(jobMessage);
        JobMessage jobMessage1 = mysqlCustomJobService.updateJob(jobMessage);
        System.out.println(jobMessage);
        return jobMessage1;
    }
}
