package com.summers.com.summers.stragegy.test.service;

import com.summers.com.summers.stragegy.test.processor.BaseProcessor;
import com.summers.registry.StrategyRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Created by SUMMERS on 2018/2/13.
 */
@Service
public class TestService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener(value = ContextRefreshedEvent.class)
    public void test(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            BaseProcessor processor = StrategyRegistry.getProcessor("test", s);
            if (processor == null){
                logger.info("------processor is null");
                System.out.println("------processor is null");
                return;
            }
            String process = processor.process();
            logger.info("------result is {}",process);
            System.out.println("---------------result is " + process);
        }
    }
}
