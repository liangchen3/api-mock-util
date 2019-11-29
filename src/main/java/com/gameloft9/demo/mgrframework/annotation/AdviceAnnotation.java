package com.gameloft9.demo.mgrframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdviceAnnotation {
}
