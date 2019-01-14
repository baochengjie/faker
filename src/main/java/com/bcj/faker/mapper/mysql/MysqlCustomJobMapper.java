package com.bcj.faker.mapper.mysql;

import com.bcj.faker.model.CustomJob;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author fengshuqin
 * @Title: MysqlCustomJobMapper
 * @ProjectName bd-asteria-server
 * @Description: 获取sql任务表信息
 * @date 2018/10/15 16:22
 */
public interface MysqlCustomJobMapper {
    List<CustomJob> getAll(CustomJob customJob);
    List<CustomJob> getListByCond(CustomJob customJob);
    List<CustomJob> getCronSchedulerJobs();
    CustomJob getByCond(CustomJob customJob);
    CustomJob get(@Param("id") int id);
    int insert(CustomJob customJob);
    int update(CustomJob customJob);
    int updateJob(int id);
    int delete(CustomJob customJob);
}
