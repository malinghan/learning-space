package com.mlh.demo.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    /**
     * Redis 连接池-最大连接数
     */
    @Value("${spring.redis.jedis.pool.max-active}")
    protected int maxActive;

    /**
     * Redis 连接池-最大空闲连接
     */
    @Value("${spring.redis.jedis.pool.max-idle}")
    protected int maxIdle;

    /**
     * Redis 连接池-最小空闲连接
     */
    @Value("${spring.redis.jedis.pool.min-idle}")
    protected int minIdle;

    /**
     * Redis 连接池-最大阻塞等待时间
     */
    @Value("${spring.redis.jedis.pool.max-wait}")
    protected int maxWait;

    /**
     * 设置RedisTemplate的序列化方式
     * @param redisTemplate
     */
    protected void setSerializer(RedisTemplate redisTemplate) {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //设置键（key）的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置值（value）的序列化方式
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
    }

    /**
     * 设置连接池属性
     * @return
     */
    public JedisPoolConfig setPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setTestOnBorrow(true); // 检测连接池连接可用性
        return poolConfig;
    }

    /**
     * 创建Redis 所需 JedisConnectionFactory
     * @param dbIndex   数据库下标
     * @param port      端口号
     * @param host      域名地址
     * @param password  连接密码
     * @return
     */
    protected JedisConnectionFactory createJedisConnectionFactory(int dbIndex, int port, String host, String password){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPassword(RedisPassword.of(password));
        configuration.setPort(port);
        configuration.setDatabase(dbIndex);

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        builder.poolConfig(setPoolConfig());
        return new JedisConnectionFactory(configuration, builder.build());
    }
}

