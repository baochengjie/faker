package com.bcj.faker.model;

import lombok.Data;

/**
 * @ClassName JobDetail
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/15 18:26
 * @Version 1.0
 **/
@Data
public class JobDetail {
    private Integer id;
    private String commandDir;
    private String commandParam;
    private String paramPrefix;
    private String commandFull;
    private Integer jobId;
    private String createTime;

    public JobDetail() {
    }

    public JobDetail(String commandDir, String commandParam, String paramPrefix, String commandFull, Integer jobId) {
        this.commandDir = commandDir;
        this.commandParam = commandParam;
        this.paramPrefix = paramPrefix;
        this.commandFull = commandFull;
        this.jobId = jobId;
    }
}
