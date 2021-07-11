package com.shan.client;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceSentinel {

    private static StatefulRedisConnection<String, String> connect;
    
    public static void init(){
        //RedisURI redisURI = RedisURI.create("redis://192.168.127.128:7000");
        RedisURI redisURI = RedisURI.builder().withSentinel("192.168.127.128", 7002)
                .withSentinelMasterId("mymaster")
                .build();
        RedisClient client = RedisClient.create(redisURI);
        connect = client.connect();//建立连接
    }
    
    static {
        init();
    }
    
    public static RedisCommands<String, String> getSentinelClient(){
        RedisCommands<String, String> sync = connect.sync();
        return sync;
    }
}
