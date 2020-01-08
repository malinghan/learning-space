package com.mlh.demo.redis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁 redis实现
 *
 * @author wangzhuo
 * @since wiki链接
 */
@Service
public class DistributedLockRedisDao {

    private static Logger logger = LoggerFactory.getLogger(DistributedLockRedisDao.class);

    @Resource(name = "redisTemplate_2")
    private RedisTemplate redisTemplate;

    private static final String LOCK_PREFIX = "LOCK:";

    private static final String LOCK_VALUE = "Locked";

    private static final int EXPIRE_SECONDS = 24 * 60 * 60;

    private String getKey(String key) {
        return LOCK_PREFIX + key;
    }

    public boolean tryLock(String key, Integer expireSeconds) {
        key = getKey(key);
        if (expireSeconds == null) expireSeconds = this.EXPIRE_SECONDS;

        //自己手动从 redisFactory拿出来的conncetion记得要手动释放！！！！
        RedisConnection redisConnection = null;
        try {
            redisConnection = redisTemplate.getConnectionFactory().getConnection();
            boolean res = redisConnection.setNX(key.getBytes("utf-8"), LOCK_VALUE.getBytes("utf-8"));

            if (!res) return false;
            try {
                redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
            } catch (Exception e) {
                releaseLock(key);
            }
            logger.debug(String.format("分布式锁：上锁 key=%s, expire_minuts =%s ", key, expireSeconds));
            return true;
        } catch (UnsupportedEncodingException e) {
            logger.error("尝试获取分布式锁时编码错误", e);
            return false;
        } finally {
            if (redisConnection != null) {
                redisConnection.close();
            }
        }

    }

    /**
     * 判断锁是否存在
     *
     * @param key
     * @return
     */
    public boolean isLocking(String key) {
        key = getKey(key);
        RedisConnection redisConnection = null;
        try {
            redisConnection = redisTemplate.getConnectionFactory().getConnection();
            return redisConnection.exists(key.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("尝试获取分布式锁时编码错误", e);
            return false;
        } finally {
            if (null != redisConnection) {
                redisConnection.close();
            }
        }
    }

    public void releaseLock(String key) {
        key = getKey(key);
        redisTemplate.delete(key);
        logger.debug(String.format("分布式锁：释放锁 key=%s", key));
    }

    public Object getLock(String key) {
        key = getKey(key);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

}
