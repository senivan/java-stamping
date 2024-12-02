package com.apps.stamping;

import java.util.function.Consumer;

public abstract class Task<T> {
    
    public boolean isFrozen = false;
    public Consumer<T> consumer;
    public String stamp;
    
    public void freeze() {
        isFrozen = true;
    }

    public void apply(T arg){
        if (!isFrozen) {
            throw new IllegalStateException("Task is not frozen");
        }
        consumer.accept(arg);
        consumer = null;
    }

}
