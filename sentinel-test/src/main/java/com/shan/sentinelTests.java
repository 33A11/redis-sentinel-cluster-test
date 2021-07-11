package com.shan;

import com.shan.client.LettuceSentinel;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;

public class sentinelTests {

    //Jedis jedisClient = JedisSentinel.getJedisClient();

    RedisCommands<String, String> syncCommand = LettuceSentinel.getSentinelClient();

    @Test
    public void test2(){
        System.out.println(syncCommand.get("hello"));
    }

    @Test
    public void test1(){
        String key = "yao";
        syncCommand.set(key, "11");
        System.out.println(syncCommand.get(key));
    }
}
