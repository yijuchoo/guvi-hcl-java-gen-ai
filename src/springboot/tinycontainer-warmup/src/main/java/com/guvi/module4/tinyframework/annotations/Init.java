package com.guvi.module4.tinyframework.annotations;

import java.lang.annotation.*;

/**
 * Marks a method that the container must call after the object is created and dependencies are injected.
 * This is our minimal lifecycle demo.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
}
