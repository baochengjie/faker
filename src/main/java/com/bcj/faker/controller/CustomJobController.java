package com.bcj.faker.controller;

import com.bcj.faker.model.CustomJob;
import com.bcj.faker.scheduler.MyScheduler;
import com.bcj.faker.service.MysqlCustomJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MysqlCustomJobService mysqlCustomJobService;
    @Autowired
    private MyScheduler myScheduler;
    //region 添加一个程序信息
    @ApiOperation(value = "创建一个新的program", notes = "注册一个新的程序")
    @GetMapping("/add_job")
    @Transactional("mysqlTransactionManager")
    public int addCustomJob(){
        CustomJob a =new CustomJob("bcj","test","test","test","0","*/10 * * * * ?","test");
        CustomJob b =new CustomJob("bcj","test01","test01","test","123","0 0 12 ? * WED","test");
        CustomJob customJob1 = mysqlCustomJobService.insert(a);
        myScheduler.addJob(customJob1);
        return 1;
    }
}
