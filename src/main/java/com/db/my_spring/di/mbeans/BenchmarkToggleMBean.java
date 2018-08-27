package com.db.my_spring.di.mbeans;

public interface BenchmarkToggleMBean {
    void setEnabled(boolean enabled);
    boolean isEnabled();
    void shutDownSystem(int code);
}
