package com.shan;

import com.shan.client.LettuceClient;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import org.junit.Test;
import reactor.core.publisher.Mono;

public class ClusterTests {

    public static RedisAdvancedClusterCommands<String,String> syncCommands = LettuceClient.getLettuceSyncClient();

    @Test
    public void test(){
        System.out.println(syncCommands.get("shan"));
    }

    @Test
    public void test1(){
        syncCommands.set("yao", "11");
    }

}
