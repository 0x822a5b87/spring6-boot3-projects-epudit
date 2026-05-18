package com.linkedbear.springboot.practice.runner;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class SmartLifecycleComponent implements SmartLifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("start smart lifecycle component");
        this.isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("stop smart lifecycle component");
        this.isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
