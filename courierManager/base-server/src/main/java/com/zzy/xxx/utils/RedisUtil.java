package com.zzy.xxx.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Redis工具类
 */
@Component
@RequiredArgsConstructor
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 写入缓存
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key     键
     * @param value   值
     * @param timeout 时间(秒)
     */
    public void set(String key, Object value, long timeout) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, timeout);
    }

    /**
     * 判断缓存中是否有对应的值
     *
     * @param key 键
     * @return 是否存在
     */
    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 获取Redis缓存中的值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param keys 键集合
     */
    public void deleteBatch(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * HashGet获取单个对象
     *
     * @param key   键
     * @param field 项
     * @return 值
     */
    public Object hGet(String key, String field) {
        HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
        return ops.get(key, field);
    }

    /**
     * 获取整个哈希存储的值
     *
     * @param key 键
     * @return Map
     */
    public Map<String, Object> hGetAll(String key) {
        HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
        return ops.entries(key);
    }

    /**
     * HashSet一个对象
     *
     * @param key   键
     * @param field 项
     * @param value 值
     */
    public void hSet(String key, String field, Object value) {
        HashOperations<String, String, Object> ops = redisTemplate.opsForHash();
        ops.put(key, field, value);
    }

    /**
     * HashSet一个对象并设置失效时间
     *
     * @param key     键
     * @param field   项
     * @param value   值
     * @param timeout 时间(秒)
     */
    public void hSet(String key, String field, Object value, long timeout) {
        hSet(key, field, value);
        redisTemplate.expire(key, timeout, java.util.concurrent.TimeUnit.SECONDS);
    }

    /**
     * 从Redis中删除指定的项
     *
     * @param key    键
     * @param fields 项
     */
    public void hDel(String key, Object... fields) {
        HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
        ops.delete(key, fields);
    }

    /**
     * 对给定的key的值做自增操作
     *
     * @param key 键
     * @return 自增后的值
     */
    public Long incr(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.increment(key);
    }

    /**
     * 对给定的key的值做自减操作
     *
     * @param key 键
     * @return 自减后的值
     */
    public Long decr(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.decrement(key);
    }

    /**
     * 将元素添加到列表的头部
     *
     * @param key   键
     * @param value 值
     * @return 列表的长度
     */
    public Long lPush(String key, Object value) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        return ops.leftPush(key, value);
    }

    /**
     * 将元素添加到列表的尾部
     *
     * @param key   键
     * @param value 值
     * @return 列表的长度
     */
    public Long rPush(String key, Object value) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        return ops.rightPush(key, value);
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @param key   键
     * @param start 起始位置，从左往右数，第一个元素位置为0
     * @param end   结束位置，从左往右数，最后一个元素位置为-1
     * @return 列表指定范围内的元素
     */
    public List<Object> lRange(String key, long start, long end) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        return ops.range(key, start, end);
    }

    /**
     * 从头部删除并返回列表中的第一个元素
     *
     * @param key 键
     * @return 列表中的第一个元素
     */
    public Object lPop(String key) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        return ops.leftPop(key);
    }

    /**
     * 从尾部删除并返回列表中的最后一个元素
     *
     * @param key 键
     * @return 列表中的最后一个元素
     */
    public Object rPop(String key) {
        ListOperations<String, Object> ops = redisTemplate.opsForList();
        return ops.rightPop(key);
    }
}
