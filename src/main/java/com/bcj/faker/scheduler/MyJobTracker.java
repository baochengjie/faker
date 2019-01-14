package com.bcj.faker.scheduler;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title: MyJobTracker
 * @ProjectName: faker
 * @Description: 定时任务跟踪记录
 * @author: baochengjie
 * @date: 2019/1/14 12:07
 */
public class MyJobTracker {
    public static ConcurrentHashMap<String, Integer> tracker = new ConcurrentHashMap<>();
}
