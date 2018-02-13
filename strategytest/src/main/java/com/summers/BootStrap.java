package com.summers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by SUMMERS on 2018/2/13.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class BootStrap{

        public static void main(String[] args){
            SpringApplication.run(BootStrap.class,args);
        }
}
