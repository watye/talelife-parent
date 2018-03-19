package com.talelife.myproject.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 这个类用配置redis服务器的连接
 * @author lwy
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {
	
	@Value("${redis.hostName:localhost}")
    private String hostName;
	
	@Value("${redis.password:123456}")
    private String password;
	
    @Value("${redis.port:6379}")
    private int port;
    
	@Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName(hostName);
        connection.setPort(port);
        connection.setPassword(password);
        return connection;
    }
}
