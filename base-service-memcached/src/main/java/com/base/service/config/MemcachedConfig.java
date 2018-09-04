package com.base.service.config;

import com.whalin.MemCached.SockIOPool;

/**
 * memcached配置
 */
public class MemcachedConfig {

    public static SockIOPool  init() {
        String[] servers = {"47.98.98.27:9999"};
        SockIOPool sockIOPool = SockIOPool.getInstance();
        sockIOPool.setServers(servers);//设置服务器地址列表
        sockIOPool.setFailover(true);//是否容错
        sockIOPool.setMinConn(5);//设置最小连接
        sockIOPool.setMaxConn(20);//设置最大连接
        sockIOPool.setInitConn(5);//初始化连接
        sockIOPool.setMaintSleep(30);//维护线程池睡眠线程时间
        sockIOPool.setSocketTO(3000);//超时时间
        sockIOPool.setNagle(false);//是否采用nagle
        sockIOPool.setAliveCheck(true);//心跳检测
        sockIOPool.setHashingAlg(SockIOPool.CONSISTENT_HASH);//采用hash算法
        sockIOPool.initialize();
        return sockIOPool;
    }

    public static void main(String[] args) {
        init();
    }
}
