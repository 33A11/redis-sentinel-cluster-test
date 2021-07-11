package com.shan.client;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

public class LettuceClient {

    private static StatefulRedisClusterConnection<String,String> connect;

    public static void init(){
        //RedisURI redisURI = RedisURI.create("redis://192.168.127.128:7000");
        RedisURI redisURI = RedisURI.builder().withHost("192.168.127.128").withPort(7000).build();
        RedisClusterClient redisClusterClient = RedisClusterClient.create(redisURI);
        //RedisClient client = RedisClient.create(redisURI);
        connect = redisClusterClient.connect();
    }

    static {
        init();
    }

    public static RedisAdvancedClusterCommands<String,String> getLettuceSyncClient(){

        RedisAdvancedClusterCommands<String, String> sync = connect.sync();
        return sync;
    }
}
