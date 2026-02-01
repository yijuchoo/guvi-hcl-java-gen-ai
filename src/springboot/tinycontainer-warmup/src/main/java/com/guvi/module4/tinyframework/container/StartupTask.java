package com.guvi.module4.tinyframework.container;

/**
 * A container-managed startup task.
 * The container calls these AFTER all beans are created and wired.
 * This is the "framework calls your code" moment.
 */
public interface StartupTask {
    void run();
}
