package com.bcj.faker.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bcj.faker.model.JobDetail;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShellUtils
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/15 15:52
 * @Version 1.0
 **/
@Slf4j
public class ShellUtils {
    public static String callShell(JobDetail jobDetail){
        //获取jobDetail里的信息
        String commandDir = jobDetail.getCommandDir();
        String commandParam = jobDetail.getCommandParam();
        String paramPrefix = jobDetail.getParamPrefix();
        boolean isEmpty = Utils.isEmpty(commandDir, commandParam, paramPrefix);
        File file = new File(commandDir);
        if(isEmpty||!file.exists()){
            log.error("参数有误...");
            return "参数有误...";
        }
        JSONObject jsonObject = JSON.parseObject(commandParam);


    }
}
