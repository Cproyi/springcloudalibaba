package org.huangyuan.redis_spring_boot_starter.config;

import org.huangyuan.redis_spring_boot_starter.property.RedissonProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

//自动装配配置类
/**1.@ConditionalOnClass(Redisson.class)：在classpath下存在该类时，
* RedissonAutoConfiguration才会实现自动装配，及引入了本工厂jar时
*/
/**
 *EnableConfigurationProperties 使@ConfigurationProperties注解生效
 */
@Configuration
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

    @Bean
    RedissonClient redissonClient(RedissonProperties redissonProperties){
        Config config = new Config();
        String prefix = "redis://";
        if(redissonProperties.isSsl()){
            prefix = "rediss://";
        }
        SingleServerConfig singleServerConfig = config.useSingleServer().
                setAddress(prefix+redissonProperties.getHost()+":" + redissonProperties.getPort()).
                setConnectTimeout(redissonProperties.getTimeout());
        if(!StringUtils.isEmpty(redissonProperties.getPassword())){
            singleServerConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }
}
