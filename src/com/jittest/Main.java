package com.jittest;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{

    public static void main(final String[] args) throws Exception
    {
        int sleepTime = 20;
        JITTest test = new JITTest(sleepTime);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Future<?> future = executor.submit(test::run);

        TimeUnit.SECONDS.sleep(20);
        test.setStopFlag(true);
        future.get();

        System.exit(0);
    }
}
