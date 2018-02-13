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

    String group() ;

    Class interfaces() default Object.class;

    String key();
}
