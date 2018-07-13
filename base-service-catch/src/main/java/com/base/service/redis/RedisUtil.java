package com.base.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis客户端工具组件
 */
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    public void setValue(String key, Object value) {
        setValue(key, value, null, null);
    }

    /**
     * key-value存储
     * @param key
     * @param value
     * @param times
     * @param timeUnit
     */
    public void setValue(String key, Object value, Long times, TimeUnit timeUnit) {
        if (key == null)
            throw new NullPointerException("key can not null for redis");

        if (times == null)
            times = 0l;

        if (timeUnit == null)
            timeUnit = TimeUnit.MILLISECONDS;

        getValueOperation().set(key, value, times, timeUnit);

    }

    /**
     * 获取值
     * @param key
     * @return
     */
    public Object getValue(String key) {
        return getValueOperation().get(key);
    }

    /**
     * 元素删除
     * @param key
     * @return
     */
    public boolean removeValue(String key) {
        return getValueOperation().getOperations().delete(key);
    }

    private ValueOperations getValueOperation() {
        return redisTemplate.opsForValue();
    }

    private ListOperations getListOperations() {
        return redisTemplate.opsForList();
    }

    private SetOperations getSetOperations() {
        return redisTemplate.opsForSet();
    }

    private ZSetOperations getZSetOperations() {
        return redisTemplate.opsForZSet();
    }

    private HashOperations getHashOperations() {
        return redisTemplate.opsForHash();
    }
}
