package com.guvi.module4.tinyframework.diagnostics;

import com.guvi.module4.tinyframework.container.TinyContainer;

import java.util.stream.Collectors;

public final class ContainerReport {
    private ContainerReport() {}

    public static void print(TinyContainer container) {
        System.out.println();
        System.out.println("========== TinyContainer Report ==========");

        String defs = container.getRegisteredImplementationTypes().stream()
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));

        String inst = container.getCreatedImplementationTypes().stream()
                .map(Class::getSimpleName)
                .collect(Collectors.joining(", "));

        System.out.println("Definitions (what the container knows how to build):");
        System.out.println("  " + (defs.isBlank() ? "<none>" : defs));

        System.out.println("Instances (objects that exist inside the container now):");
        System.out.println("  " + (inst.isBlank() ? "<none>" : inst));

        System.out.println("=========================================");
        System.out.println();
    }
}
