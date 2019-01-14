package com.bcj.faker.utils;

/**
 * @Title: Result
 * @ProjectName: faker
 * @Description: TODO
 */
public class MyResult<T> {

    public int status;
    public String message;
    public T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
