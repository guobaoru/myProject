package com.guobaoru.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Created by guobaoru.
 * @create on 2019/3/6.
 */

// 该注解类型 - 加载类和方法上
@Target({ElementType.TYPE, ElementType.METHOD})
// 运行时使用
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnno {

    /**
     * 如果只有一个值，value可以不写
     * default 也可以不写，但是不写后，在使用注解的时候必须传值
     * @return
     */
    public String value() default "";

}
