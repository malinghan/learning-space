package com.mlh.demo.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisScannerConfigEleven extends RedisConfig {

    /** Redis 服务器主机 */
    @Value("${spring.redis.host}")
    private String host;

    /** Redis 登录密码 */
    @Value("${spring.redis.password}")
    private String password;

    /** Redis 登录端口号 */
    @Value("${spring.redis.port}")
    private int port;

    /** Redis 操作数据库下标 */
    @Value("${spring.redis.database.eleven}")
    private int dbIndex;

    @Bean
    public JedisConnectionFactory redisConnectionFactoryEleven() {
        return createJedisConnectionFactory(dbIndex, port, host, password);
    }

    /**
     * 配置RedisTemplate 注入方式使用@Resource(name="") 方式注入
     *
     * @return
     */
    @Bean(name = "redisTemplate_11")
    public RedisTemplate redisTemplateEleven() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactoryEleven());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }
}


