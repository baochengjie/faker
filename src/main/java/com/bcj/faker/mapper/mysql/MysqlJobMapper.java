package com.bcj.faker.mapper.mysql;

import com.bcj.faker.dto.JobMessage;
import com.bcj.faker.model.CustomJob;
import com.bcj.faker.model.CustomJobDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengshuqin
 * @Title: MysqlJobMapper
 * @ProjectName bd-asteria-server
 * @Description: 获取sql任务表信息
 * @date 2018/10/15 16:22
 */
public interface MysqlJobMapper {
    List<CustomJob> getAll(CustomJob customJob);
    List<CustomJob> getListByCond(CustomJob customJob);

    List<CustomJob> getCronSchedulerJobs();

    List<JobMessage> getCronSchedulerJobMessages();
    CustomJob getByCond(CustomJob customJob);
    CustomJob get(@Param("id") int id);
    int insertCustomJob(CustomJob customJob);
    int insertCustomJobDetail(CustomJobDetail customJobDetail);
    int updateCustomJob(CustomJob customJob);
    int updateCustomJobDetail(CustomJobDetail customJob);

    int updateJobTime(int id);
    int delete(CustomJob customJob);

}
