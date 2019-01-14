package com.bcj.faker.utils;

/**
 * @Title: ResultUtil
 * @ProjectName: faker
 * @Description: TODO
 */
public class MyResultUtil {

    public static MyResult SUCCESS(Object data){
        MyResult<Object> myResult = new MyResult<Object>();
        myResult.setStatus(200);
        myResult.setMessage("success");
        myResult.setData(data);

        return myResult;
    }

    public static MyResult SUCCESS(int code, String message, Object data){
        MyResult<Object> myResult = new MyResult<Object>();
        myResult.setStatus(code);
        myResult.setMessage(message);
        myResult.setData(data);

        return myResult;
    }

    public static MyResult ERROR(int status, String message){
        MyResult<Object> myResult = new MyResult<>();
        myResult.setStatus(status);
        myResult.setMessage(message);

        return myResult;
    }
}
