package com.guvi.module4.tinyframework.container;

import java.util.*;

/**
 * Stores already-created bean instances.
 * In Spring, this is similar to the singleton cache inside the ApplicationContext.
 */
final class InstanceRegistry {
    private final Map<Class<?>, Object> instances = new LinkedHashMap<>();

    void put(Class<?> implType, Object instance) {
        instances.put(implType, instance);
    }

    Object get(Class<?> implType) {
        return instances.get(implType);
    }

    boolean containsKey(Class<?> implType) {
        return instances.containsKey(implType);
    }

    Set<Class<?>> keys() {
        return instances.keySet();
    }

    Map<Class<?>, Object> snapshot() {
        return Collections.unmodifiableMap(instances);
    }
}
