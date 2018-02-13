package com.summers.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by SUMMERS on 2018/2/12.
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface StrategyGroup {

    String group() ;//对应不同的业务场景

    Class interfaces() default Object.class; //父接口类

    String key(); //业务场景中 关联到具体的processor的映射key
}
