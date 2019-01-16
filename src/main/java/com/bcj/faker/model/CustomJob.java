package com.bcj.faker.model;

import com.bcj.faker.utils.json.JsonTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author baochengjie
 * @Title: CustomJob
 * @ProjectName faker
 * @Description: SQL任务表
 */
@Data
public class CustomJob implements Serializable {
    private Integer id;
    private String owner; // 创建人
    private String jobName; //任务名称
    private String showName; // 显示名称
    private String schedule; // 是否定时任务 （0是  1 否）
    private String scheduleCrontab; // 定时计划
    private String description; // 描述
    //@JsonSerialize(using = JsonTimeSerializer.class)
    private String createTime; // 创建时间
    @JsonSerialize(using = JsonTimeSerializer.class)
    private Date updateTime; // 更新时间
    @JsonSerialize(using = JsonTimeSerializer.class)
    private Date updateJobTime;// job更新时间

    public CustomJob() {
    }

    public CustomJob(String owner, String jobName, String showName, String schedule, String scheduleCrontab, String description) {
        this.owner = owner;
        this.jobName = jobName;
        this.showName = showName;
        this.schedule = schedule;
        this.scheduleCrontab = scheduleCrontab;
        this.description = description;
    }

    @Override
    public String toString() {
        return "CustomJob{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", jobName='" + jobName + '\'' +
                ", showName='" + showName + '\'' +
                ", schedule='" + schedule + '\'' +
                ", scheduleCrontab='" + scheduleCrontab + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updateJobTime=" + updateJobTime +
                '}';
    }
}
