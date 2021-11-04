package com.jittest;

import java.util.concurrent.*;


class JITTest {
    private int intValue = 0;

    public void setIntValueAsOdd() { intValue = 0x5566; }
    public boolean isIntValueEqual(){
        return intValue == 0x5566;
    }
    public void jitTest() {
        int testValue = 0;
        while (!isIntValueEqual()) {
            testValue += 0x7788;
        }
    }
}

public class Main {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {

        JITTest jitTest = new JITTest();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Future<?> future = executor.submit(()->{
            jitTest.jitTest();
        });
        TimeUnit.SECONDS.sleep(1);
        jitTest.setIntValueAsOdd();
        future.get();
        System.exit(0);

    }
}
