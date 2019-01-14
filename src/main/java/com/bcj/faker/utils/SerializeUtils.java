package com.bcj.faker.utils;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Title: SerializeUtils
 * @ProjectName: faker
 * @Description: 序列化
 */
@Slf4j
public class SerializeUtils {

    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {

        try{
            @Cleanup ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            @Cleanup ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(object);

            byte[] bytes = byteArrayOutputStream.toByteArray();

            return bytes;
        }catch (Exception e){
            log.error("序列化异常",e);
        }

        return null;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {

        try{
            @Cleanup ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            @Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return objectInputStream.readObject();
        }catch (Exception e){
            log.error("反序列化异常", e);
        }

        return null;
    }
}
