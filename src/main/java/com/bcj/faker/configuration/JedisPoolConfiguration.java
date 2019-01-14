package com.bcj.faker.configuration;

import lombok.Data;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @Title: JedisPoolConfiguration
 * @ProjectName: faker
 * @Description: TODO
 * @author: baochengjie
 * @date: 2018/12/6 11:04
 */
@Data
@Configuration
@ConfigurationProperties("spring.redis")
public class JedisPoolConfiguration {
    private String host;
    private int port;
    private int maxIdle;
    private int minIdle;
    private int maxWait;
    private int expire;
    private int database;

    @Bean("myRedisPool")
    public JedisPool getJedisPool() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
        JedisPool jedisPool = new JedisPool(genericObjectPoolConfig, host, port);

        return jedisPool;
    }

}
