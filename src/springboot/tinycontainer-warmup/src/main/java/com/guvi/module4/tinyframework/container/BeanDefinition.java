package com.guvi.module4.tinyframework.container;

import java.lang.reflect.Constructor;

/**
 * A BeanDefinition is the container's "recipe" for creating a bean.
 * - which concrete class to build
 * - which constructor to use
 */
final class BeanDefinition {
    private final Class<?> implType;
    private final Constructor<?> constructor;

    BeanDefinition(Class<?> implType, Constructor<?> constructor) {
        this.implType = implType;
        this.constructor = constructor;
    }

    Class<?> getImplType() {
        return implType;
    }

    Constructor<?> getConstructor() {
        return constructor;
    }
}
