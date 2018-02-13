package com.summers.com.summers.stragegy.test.processor;

import com.summers.annotation.StrategyGroup;
import org.springframework.stereotype.Component;

/**
 * Created by SUMMERS on 2018/2/13.
 */
@StrategyGroup(group = "test",interfaces = BaseProcessor.class,key = "a")
@Component
public class ATestProcessor implements BaseProcessor {
    @Override
    public String process() {
        return "a test processor";
    }
}
