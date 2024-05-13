package com.edg.reflection;

import java.lang.annotation.*;

/**
 * @auther zyt
 * @date 2024/5/13
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
}
