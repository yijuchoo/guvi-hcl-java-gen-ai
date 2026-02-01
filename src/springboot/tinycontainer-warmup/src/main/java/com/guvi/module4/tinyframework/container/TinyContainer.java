package com.guvi.module4.tinyframework.container;

import com.guvi.module4.tinyframework.annotations.Init;
import com.guvi.module4.tinyframework.exceptions.CircularDependencyException;
import com.guvi.module4.tinyframework.exceptions.NoBeanDefinitionException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * TinyContainer is a minimal IoC container.
 *
 * It demonstrates the core idea behind frameworks like Spring:
 * - store definitions (recipes)
 * - create instances
 * - resolve constructor dependencies
 * - call init methods
 * - run startup tasks
 */
public final class TinyContainer {

    private final DefinitionRegistry definitionRegistry = new DefinitionRegistry();
    private final InstanceRegistry instanceRegistry = new InstanceRegistry();

    // Creation diagnostics
    private final List<String> creationLog = new ArrayList<>();

    // Tracks recursion to detect circular dependencies
    private final Deque<Class<?>> creationStack = new ArrayDeque<>();

    /**
     * Register a concrete class as a container-managed bean.
     */
    public void register(Class<?> implType) {
        Objects.requireNonNull(implType, "implType");

        if (definitionRegistry.containsKey(implType)) {
            return;
        }

        Constructor<?> ctor = pickConstructor(implType);
        definitionRegistry.put(implType, new BeanDefinition(implType, ctor));
    }

    /**
     * Start the container:
     * 1) create and wire all registered beans
     * 2) run init methods
     * 3) run StartupTask beans
     */
    public void start() {
        System.out.println("========== TinyContainer Startup ==========");

        System.out.println("Registered definitions:");
        for (Class<?> c : definitionRegistry.keys()) {
            System.out.println("  - " + c.getName());
        }

        // Create all registered beans
        for (BeanDefinition def : definitionRegistry.all()) {
            getBean(def.getImplType());
        }

        // Run startup tasks
        List<StartupTask> tasks = new ArrayList<>();
        for (Class<?> impl : instanceRegistry.keys()) {
            Object obj = instanceRegistry.get(impl);
            if (obj instanceof StartupTask task) {
                tasks.add(task);
            }
        }

        if (!tasks.isEmpty()) {
            System.out.println();
            System.out.println("Running startup tasks:");
            for (StartupTask task : tasks) {
                System.out.println("  - " + task.getClass().getName());
                task.run();
            }
        }

        System.out.println("===========================================");
        System.out.println();
    }

    /**
     * Retrieve a bean by requested type.
     * - If requested type is a registered concrete type, return it.
     * - If requested type is an interface or parent type, find a single matching implementation.
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> requestedType) {
        Objects.requireNonNull(requestedType, "requestedType");

        Class<?> implType = resolveImplementation(requestedType);

        if (instanceRegistry.containsKey(implType)) {
            return (T) instanceRegistry.get(implType);
        }

        BeanDefinition def = definitionRegistry.get(implType);
        if (def == null) {
            throw new NoBeanDefinitionException("No bean definition found for: " + requestedType.getName());
        }

        if (creationStack.contains(implType)) {
            String cycle = creationStack.stream().map(Class::getSimpleName).toList() + " -> " + implType.getSimpleName();
            throw new CircularDependencyException("Circular dependency detected: " + cycle);
        }

        creationStack.push(implType);
        try {
            Object created = createFromDefinition(def);
            instanceRegistry.put(implType, created);
            return (T) created;
        } finally {
            creationStack.pop();
        }
    }

    /**
     * For reporting.
     */
    public Set<Class<?>> getRegisteredImplementationTypes() {
        return new LinkedHashSet<>(definitionRegistry.keys());
    }

    /**
     * For reporting.
     */
    public Set<Class<?>> getCreatedImplementationTypes() {
        return new LinkedHashSet<>(instanceRegistry.keys());
    }

    private Object createFromDefinition(BeanDefinition def) {
        Class<?> implType = def.getImplType();
        Constructor<?> ctor = def.getConstructor();

        System.out.println();
        System.out.println("Creating: " + implType.getName());

        Class<?>[] paramTypes = ctor.getParameterTypes();
        Object[] args = new Object[paramTypes.length];

        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> depType = paramTypes[i];
            System.out.println("  Resolving dependency: " + depType.getName());
            args[i] = getBean(depType);
        }

        try {
            Object instance = ctor.newInstance(args);
            invokeInitMethods(instance);
            System.out.println("Created: " + implType.getName());
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create bean: " + implType.getName(), e);
        }
    }

    private void invokeInitMethods(Object instance) {
        Method[] methods = instance.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (!m.isAnnotationPresent(Init.class)) {
                continue;
            }
            if (m.getParameterCount() != 0) {
                throw new IllegalStateException("@Init method must have zero parameters: " + m);
            }
            try {
                m.setAccessible(true);
                System.out.println("  Calling @Init: " + instance.getClass().getName() + "." + m.getName() + "()");
                m.invoke(instance);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Failed to invoke @Init method: " + m, e);
            }
        }
    }

    private Constructor<?> pickConstructor(Class<?> implType) {
        Constructor<?>[] ctors = implType.getConstructors();

        if (ctors.length == 0) {
            // No public constructor; try declared no-arg
            try {
                Constructor<?> declared = implType.getDeclaredConstructor();
                declared.setAccessible(true);
                return declared;
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("No public constructors and no default constructor found for: " + implType.getName());
            }
        }

        if (ctors.length == 1) {
            return ctors[0];
        }

        // Multiple public constructors: choose the one with most parameters (simple heuristic)
        Constructor<?> best = ctors[0];
        for (Constructor<?> c : ctors) {
            if (c.getParameterCount() > best.getParameterCount()) {
                best = c;
            }
        }
        return best;
    }

    private Class<?> resolveImplementation(Class<?> requestedType) {
        // Exact match
        if (definitionRegistry.containsKey(requestedType)) {
            return requestedType;
        }

        // Otherwise find a single implementation assignable to requestedType
        List<Class<?>> candidates = new ArrayList<>();
        for (Class<?> impl : definitionRegistry.keys()) {
            if (requestedType.isAssignableFrom(impl)) {
                candidates.add(impl);
            }
        }

        if (candidates.isEmpty()) {
            throw new NoBeanDefinitionException(
                    "No registered implementation found for requested type: " + requestedType.getName()
            );
        }

        if (candidates.size() > 1) {
            String names = candidates.stream().map(Class::getName).reduce((a, b) -> a + ", " + b).orElse("");
            throw new IllegalStateException(
                    "Multiple implementations found for " + requestedType.getName() + ": " + names
            );
        }

        return candidates.get(0);
    }
}
