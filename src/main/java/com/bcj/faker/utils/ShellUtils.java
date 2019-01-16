package com.bcj.faker.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.bcj.faker.model.CustomJobDetail;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShellUtils
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/15 15:52
 * @Version 1.0
 **/
@Slf4j
public class ShellUtils {
    public static String callShell(CustomJobDetail jobDetail) {
        //获取jobDetail里的信息
        String commandDir = jobDetail.getCommandDir();
        String commandParam = jobDetail.getCommandParam();
        String paramPrefix = jobDetail.getParamPrefix();

        boolean isEmpty = Utils.isEmpty(commandDir, commandParam, paramPrefix);
        File file = new File(commandDir);
        if (isEmpty /*|| !file.exists()*/) {
            log.error("参数有误...");
            return "参数有误...";
        }
        try {
            JSONObject jsonObject = JSON.parseObject(commandParam,Feature.OrderedField);
            String[] arrParams = new String[jsonObject.size() + 1];
            arrParams[0] = commandDir;
            Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
            int index = 1;
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String element = paramPrefix + next.getKey() + " " + next.getValue();
                arrParams[index] = element;
                index++;
            }
            /*Process process = null;
            log.info("开始执行命令......");
            process = Runtime.getRuntime().exec(arrParams);
            int i = process.waitFor();
            if(i!=0){
                return "任务异常退出...";
            }
            return "任务执行成功...";*/
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<arrParams.length;i++){
                sb.append(arrParams[i]+"\n");
            }
            return sb.toString();
        }catch (Exception e){
            return "程序处理异常:"+e.toString();
        }
    }
}
