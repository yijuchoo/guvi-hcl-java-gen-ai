package com.guvi.module4.student.main;

import com.guvi.module4.tinyframework.annotations.Init;

/**
 * A tiny bean purely to demonstrate lifecycle.
 * The container will call the @Init method after creation.
 */
public class LifecycleProbe {

    public LifecycleProbe() {
        System.out.println("LifecycleProbe constructor: object created");
    }

    @Init
    public void onInit() {
        System.out.println("LifecycleProbe @Init: dependencies would be ready now");
    }
}
