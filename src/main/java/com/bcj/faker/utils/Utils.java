package com.bcj.faker.utils;


import com.bcj.faker.utils.constant.Constant;

/**
 * @author baochengjie
 * @Title: Utils
 * @ProjectName faker
 * @Description: 处理工具类
 * @date 2018/10/17 15:14
 */
public class Utils {
    /* *
     * @Description: cron转换 秒分时天月周年
     * @param [scheduleCrontab]
     * @return java.lang.String
     * @throws
     * @author fengshuqin
     * @date 2018/10/25
     */
    public static String getCron(String scheduleCrontab){
        // 0:12:30 （0~7 依次代表每天、星期一、星期二）
        if (isEmpty(scheduleCrontab)) {
            return "0 0 12 ? * SAT"; // 默认定时为：每周六12点
        }
        else{
            return scheduleCrontab;
        }
    }

    /* *
     * @Description: 转换天或星期
     * @param [num]
     * @return java.lang.String
     * @throws
     * @author fengshuqin
     * @date 2018/10/25
     */
    public static String getWeekDay(int num){
        switch (num){
            case 0: return Constant.ZERO;
            case 1: return "MON";
            case 2: return "TUE";
            case 3: return "WED";
            case 4: return "THU";
            case 5: return "FRI";
            case 6: return "SAT";
            case 7: return "SUN";
            default: break;
        }
        return "";
    }

    /* *
     * @Description: 判断为空
     * @param [cs]
     * @return boolean
     * @throws
     * @author fengshuqin
     * @date 2018/10/18
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0 || cs == "null" || "null".equals(cs);
    }
    public static boolean isEmpty(Object... params){
        boolean flag = true;
        for(int i=0;i<params.length;i++){
            String param = params[i].toString();
            if("".equals(param)||param==null){
                flag = false;
                break;
            }
        }
        return !flag;
    }

}