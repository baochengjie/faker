package com.bcj.faker.service;

import com.bcj.faker.dto.JobMessage;
import com.bcj.faker.mapper.mysql.MysqlJobMapper;
import com.bcj.faker.model.CustomJob;
import com.bcj.faker.model.CustomJobDetail;
import com.bcj.faker.utils.Utils;
import com.bcj.faker.utils.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author baochengjie
 * @Title: faker
 * @ProjectName bd-asteria-server
 * @Description: CustomJob Service
 * @date 2018/10/15 16:30
 */
@Service
public class MysqlJobService {

    @Autowired
    private MysqlJobMapper customJobMapper;


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
     * @param [JobMessager] 插入job 和job_detail两张表
     * @return int
     */
    @Transactional("mysqlTransactionManager")
    public JobMessage insertJob(JobMessage jobMessage) {
        CustomJob customJob = jobMessage.getCustomJob();
        CustomJobDetail customJobDetail = jobMessage.getCustomJobDetail();
        Date currentDate = new Date();// 当前时间
        customJob.setShowName(customJob.getJobName() + Constant.SEPARATOR + sf.format(currentDate)
                + Constant.SEPARATOR + customJob.getOwner());//显示名称
        jobMessage.setCustomJob(customJob);
        customJobMapper.insertCustomJob(customJob);
        customJobDetail.setJobId(customJob.getId());
        customJobMapper.insertCustomJobDetail(customJobDetail);
        return jobMessage;
    }
    @Transactional("mysqlTransactionManager")
    public JobMessage updateJob(JobMessage jobMessage) {
        CustomJob customJob = jobMessage.getCustomJob();
        CustomJobDetail customJobDetail = jobMessage.getCustomJobDetail();
        customJob.setShowName(customJob.getJobName() + Constant.SEPARATOR + customJob.getCreateTime().split(" ")[0].replaceAll("-","")
                + Constant.SEPARATOR + customJob.getOwner());//显示名称
        jobMessage.setCustomJob(customJob);
        customJobMapper.updateCustomJob(customJob);
        customJobMapper.updateCustomJobDetail(customJobDetail);
        return jobMessage;
    }
    /* *
     * @Description: 执行定时任务 修改操作时间
     * @param [id]
     * @return int
     * @throws
     */
    public int modifyJob(int id) throws Exception {
        return customJobMapper.updateJobTime(id);
    }

    public List<CustomJob> getCronSchedulerJobs() {
        return customJobMapper.getCronSchedulerJobs();
    }

    public List<JobMessage> getCronSchedulerJobMessages() {
        return customJobMapper.getCronSchedulerJobMessages();
    }

    /* *
     * @Description: 修改showName
     * @param [oldJobName, oldShowName, newName]
     * @return java.lang.String
     * @throws
     */
    public static String getNewStr(String oldJobName, String oldShowName, String newName) {
        if (!Utils.isEmpty(oldJobName) && !Utils.isEmpty(oldShowName) && !Utils.isEmpty(newName)) {
            oldShowName = oldShowName.substring(oldJobName.length());
            return newName + oldShowName;
        } else {
            return "";
        }
    }
}
