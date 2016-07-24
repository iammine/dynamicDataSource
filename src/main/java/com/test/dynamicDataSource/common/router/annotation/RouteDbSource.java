package com.test.dynamicDataSource.common.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jd on 2016/7/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RouteDbSource {
    String routeField() default "name";
    String tableStyle() default "_0000";
}
