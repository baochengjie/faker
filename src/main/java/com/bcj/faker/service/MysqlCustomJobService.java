package com.bcj.faker.service;

import com.bcj.faker.mapper.mysql.MysqlCustomJobMapper;
import com.bcj.faker.model.CustomJob;
import com.bcj.faker.utils.HandleUtils;
import com.bcj.faker.utils.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author fengshuqin
 * @Title: MysqlCustomJobService
 * @ProjectName bd-asteria-server
 * @Description: CustomJob Service
 * @date 2018/10/15 16:30
 */
@Service
public class MysqlCustomJobService {

    @Autowired
    private MysqlCustomJobMapper customJobMapper;


    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

    /*
     * @Description: 获取 全部 自定义sql列表信息 customJob
     * @param []
     * @throws
     * @date 2018/10/15
     */
    public List<CustomJob> getAll(CustomJob customJob) throws Exception {
        return customJobMapper.getAll(customJob);
    }

    /* *
     * @Description: 获取 当前用户 自定义sql列表信息 customJob
     * @param [customJob]
     */
    public List<CustomJob> getListByCond(CustomJob customJob) throws Exception {
        return customJobMapper.getListByCond(customJob);
    }

    /* *
     * @Description: 添加
     * @param [customJob]
     * @return int
     */
    public CustomJob insert(CustomJob customJob) {
        Date currentDate = new Date();// 当前时间
        customJob.setCreateTime(currentDate);
        customJob.setUpdateTime(currentDate);
        customJob.setShowName(customJob.getJobName() + Constant.SEPARATOR + sf.format(currentDate)
                + Constant.SEPARATOR + customJob.getOwner());//显示名称
        customJobMapper.insert(customJob);
        return customJob;
    }

    /* *
     * @Description: 执行定时任务 修改操作时间
     * @param [id]
     * @return int
     * @throws
     */
    public int modifyJob(int id) throws Exception {
        return customJobMapper.updateJob(id);
    }

    public List<CustomJob> getCronSchedulerJobs() {
        return customJobMapper.getCronSchedulerJobs();
    }

    /* *
     * @Description: 修改showName
     * @param [oldJobName, oldShowName, newName]
     * @return java.lang.String
     * @throws
     */
    public static String getNewStr(String oldJobName, String oldShowName, String newName) {
        if (!HandleUtils.isEmpty(oldJobName) && !HandleUtils.isEmpty(oldShowName) && !HandleUtils.isEmpty(newName)) {
            oldShowName = oldShowName.substring(oldJobName.length());
            return newName + oldShowName;
        } else {
            return "";
        }
    }
}
