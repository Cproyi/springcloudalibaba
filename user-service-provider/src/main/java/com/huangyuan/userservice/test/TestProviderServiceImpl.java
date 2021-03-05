package com.huangyuan.userservice.test;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * dubbo 容错机制
 * cluster:
 * failover 调用失败自动切换集群服务并重试，默认重试次数为2
 * failfast 快速失败，失败后直接返回，适用于新增操作
 * failsafe 失败后忽略异常
 * failback 适用于消息
 * forking  并行调用集群中的多个服务，只要一个成功就返回
 * broadcast 广播调用所有集群中的服务，有一个失败则整个调用失败
 *
 * 接口设计把查询与增删改服务分开，使用不同的容错机制，
 * 查询建议使用failover retries=2
 * 增删改建议使用failfast 或 failover retries=0
 *
 * dubbo负载均衡
 * random 加权随机
 * roundRobin 加权轮询
 * leastActive 最少活跃调用数，慢的节点获得更少调用
 * consistentHash 一致性哈希，相同参数的请求始终找到同一个服务提供者
 */
@Service(cluster = "failover",retries = 2,loadbalance = "random")
public class TestProviderServiceImpl implements TestProviderService{

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${dubbo.protocol.port}")
    private String dubboport;

    @Override
    public String test(String command) {
        return String.format("%s received %s ,reply with hi,dubbo port:%s",applicationName,command,dubboport);
    }
}
