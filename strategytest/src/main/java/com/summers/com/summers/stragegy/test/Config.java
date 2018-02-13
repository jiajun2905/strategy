package com.summers.com.summers.stragegy.test;

import com.summers.integration.SpringIntegration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SUMMERS on 2018/2/13.
 */
@Configuration
public class Config {

    @Bean
    public SpringIntegration springIntegration(){
        return new SpringIntegration();
    }
}
