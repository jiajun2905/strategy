package com.summers.com.summers.stragegy.test.processor;

import com.summers.annotation.StrategyGroup;
import org.springframework.stereotype.Component;

/**
 * Created by SUMMERS on 2018/2/13.
 */
@Component
@StrategyGroup(group = "other",key = "c")
public class COtherProcessor implements OtherBaseProcessor{
    @Override
    public String process() {
        return "c other processor";
    }
}
