package com.wyy.pervider_shiro_1006_p2p.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheTransfer {
    /**
     * 这里先是使用 Autowired 注入 操作redis的模板类，
     * 然后呢在使用静态静态注入的方式放入注入RedisCache
     * @param redisTemplate
     */
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}

