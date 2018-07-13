package com.base.service.web;

import com.base.service.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/set")
    public String redisSet(@RequestParam String key, String value) {
        redisUtil.setValue(key, value);
        return "success";
    }

    @GetMapping("/get")
    public Object redisGet(@RequestParam String key) {
        return redisUtil.getValue(key);
    }
}
