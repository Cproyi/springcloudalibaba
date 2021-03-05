package org.huangyuan.redis_spring_boot_starter.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties 把当前类中的属性和配置文件（application.xml/properties）中的配置进行绑定
@ConfigurationProperties(prefix = "hy.redisson")
public class RedissonProperties {

    private String host = "localhost";

    private String password;

    private int port = 6379;

    private int timeout;

    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
