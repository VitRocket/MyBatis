package com.github.vitrocket.mybatis.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vit Rocket on 21.11.2017.
 * @version 1.0
 * @since on 21.11.2017
 */
@Configuration
public class SecurityConfig {

    @Bean
    public Realm realm() {
        // uses 'classpath:shiro-users.properties' by default
        PropertiesRealm realm = new PropertiesRealm();
        realm.setCachingEnabled(true);
        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "authcBasic[permissive]");
        return chainDefinition;
    }

    @Bean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }
}
