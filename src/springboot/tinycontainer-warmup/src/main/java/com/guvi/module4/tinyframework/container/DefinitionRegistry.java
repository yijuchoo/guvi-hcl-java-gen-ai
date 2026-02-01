package com.guvi.module4.tinyframework.container;

import java.util.*;

/**
 * Stores the container's creation plans (definitions).
 * This answers the question: "After registration/scanning, where does Spring keep things?"
 */
final class DefinitionRegistry {
    private final Map<Class<?>, BeanDefinition> definitions = new LinkedHashMap<>();

    void put(Class<?> implType, BeanDefinition def) {
        definitions.put(implType, def);
    }

    BeanDefinition get(Class<?> implType) {
        return definitions.get(implType);
    }

    Collection<BeanDefinition> all() {
        return definitions.values();
    }

    Set<Class<?>> keys() {
        return definitions.keySet();
    }

    boolean containsKey(Class<?> implType) {
        return definitions.containsKey(implType);
    }
}
