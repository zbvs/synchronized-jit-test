package com.jittest;

import java.util.concurrent.TimeUnit;

public class JITTest {

    private boolean stopFalg = false;
    private final int sleepTime;
    JITTest(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    private boolean isStopFlagTrue() {
        try {
            TimeUnit.NANOSECONDS.sleep(1);
        } catch (Exception ignore) { }
        return stopFalg;
    }

    public boolean jittest() {
        long timeStart = System.nanoTime();
        isStopFlagTrue();
        long result = System.nanoTime() - timeStart;
        return isStopFlagTrue();
    }
    public void run() {
        while(!jittest()){}
    }
    public void setStopFlag(boolean flag) { stopFalg = flag; }
}
