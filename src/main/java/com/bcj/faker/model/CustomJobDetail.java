package com.bcj.faker.model;

import lombok.Data;

/**
 * @ClassName CustomJobDetail
 * @Description TODO
 * @Author baochengjie
 * @Date 2019/1/15 18:26
 * @Version 1.0
 **/
@Data
public class CustomJobDetail {
    private Integer id;
    private String commandDir;
    private String commandParam;
    private String paramPrefix;
    private String commandFull;
    private Integer jobId;
    private String createTime;

    public CustomJobDetail() {
    }

    public CustomJobDetail(String commandDir, String commandParam, String paramPrefix, String commandFull, Integer jobId) {
        this.commandDir = commandDir;
        this.commandParam = commandParam;
        this.paramPrefix = paramPrefix;
        this.commandFull = commandFull;
        this.jobId = jobId;
    }

    public CustomJobDetail(String commandDir, String commandParam, String paramPrefix) {
        this.commandDir = commandDir;
        this.commandParam = commandParam;
        this.paramPrefix = paramPrefix;
    }
}
