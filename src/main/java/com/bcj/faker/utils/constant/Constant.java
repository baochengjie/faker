package com.bcj.faker.utils.constant;

/**
 * @author baochengjir
 * @Title: Constant
 * @ProjectName faker
 * @Description: 常量信息
 */
public class Constant {

    public static String TABLE_PREFIX = "asteria_";
    public static String SQL_SELECT = "select ";
    public static String SQL_FORM = " from ";
    public static String SQL_AS = " as ";
    public static String SQL_COMMA = ",";
    public static String SQL_DEFAULT_COLUMN = "A";
    public static String QUOTATION_MARK = "'";
    public static String SEPARATOR = "-";
    public static String COLON = ":";
    public static String BLANK = " ";
    //    public static String MATCH_ALL = "*";
    public static String ZERO = "0";
    public static String CARRIAGE_RETURN = "\n";
    public static String CRONTAB = "0 0 * * * ?";
//    public static int ROOT = 0; // 根节点

    public static String INSERT = "insert"; // 添加
    public static String UPDATE = "update"; // 修改

    public static String JOB_SQL_GET = "/asteria/get/custom/sql";
    public static String JOB_SQL_GET_ALL = "/asteria/get/all/custom/sql";
    public static String JOB_SQL_PUT = "/asteria/put/custom/sql";
    public static String JOB_SQL_UPDATE = "/asteria/update/custom/sql";
    public static String JOB_SQL_EXECUTE = "/asteria/execute/custom/sql";
    public static String JOB_SQL_DELETE = "/asteria/delete/custom/sql";
    public static String JOB_SQL_GET_RELATION = "/asteria/get/relation/custom/sql";
    public static String JOB_SQL_RENAME = "/asteria/isrename/custom/sql";
    public static String JOB_SQL_MODIFY = "/asteria/modify/custom/sql";

    public static String FOLDER_PUT = "/asteria/put/custom/dashboard/folder";
    public static String FOLDER_UPDATE = "/asteria/update/custom/dashboard/folder";
    public static String FOLDER_DELETE = "/asteria/delete/custom/dashboard/folder";
    public static String FOLDER_GET_ALL ="/asteria/get/all/custom/dashboard/folder";
    public static String FOLDER_GET_UNION ="/asteria/get/union/custom/dashboard/folder";
    public static String FOLDER_GET_UNION_BY_ROLE ="/asteria/get/union/by/role/custom/dashboard/folder";

    public static String DASHBORD_GET_ALL ="/asteria/get/all/custom/dashboard";
    public static String DASHBORD_PUT = "/asteria/put/custom/dashboard";
    public static String DASHBORD_UPDATE = "/asteria/update/custom/dashboard";
    public static String DASHBORD_DELETE = "/asteria/delete/custom/dashboard";
    public static String DASHBORD_MOVE = "/asteria/move/custom/dashboard";
    public static String DASHBORD_SAVE = "/asteria/save/custom/dashboard";

    public static String CUSTOM_CHAT_GET = "/asteria/get/custom/chat";
    //    public static String CUSTOM_CHAT_PUT = "/asteria/put/custom/chat";
    public static String CUSTOM_CHAT_COPY = "/asteria/copy/custom/chat";
    public static String CUSTOM_CHAT_EDIT = "/asteria/edit/custom/chat";
    public static String CUSTOM_CHAT_DELETE = "/asteria/delete/custom/chat";
    public static String CUSTOM_CHAT_RECORD = "/asteria/record/custom/chat";

    public static String ROLE_PERMISSION_ALL = "/asteria/get/all/custom/role/permission";
    public static String ROLE_PERMISSION_BY_ROLE = "/asteria/get/by/role/custom/role/permission";
    public static String ROLE_PERMISSION_SAVE = "/asteria/save/custom/role/permission";

    public static String DASHBORD_ROLE_ALL = "/asteria/get/all/custom/dashboard/role";
    public static String DASHBORD_ROLE_BY_ID = "/asteria/get/by/dashboard/custom/dashboard/role";
    public static String DASHBORD_ROLE_SAVE = "/asteria/save/custom/dashboard/role";

}
