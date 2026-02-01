package com.guvi.module4.tinyframework.annotations;

import java.lang.annotation.*;

/**
 * Marks a class as a container-managed component.
 *
 * In this warmup, we still register classes explicitly in AppMain to keep things simple.
 * Later, you can extend TinyContainer to discover @Component classes automatically.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
}
