package com.db.my_spring.di;

import com.db.my_spring.di.annotations.InjectByType;
import com.db.my_spring.irobot.Cleaner;
import com.db.my_spring.irobot.CleanerImpl;

public class BenchmarkCleaner implements Cleaner {

    @InjectByType
    private CleanerImpl cleaner;

    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println("Duration: " + (end - start));
    }
}
