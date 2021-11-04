package com.jittest;

import java.util.concurrent.TimeUnit;

public class Main
{
    private static boolean stopFalg = false;
    private static boolean isStopFlagTrue() {
        return stopFalg;
    }

    public static void run() {
        int i = 0;
        while (!isStopFlagTrue()) {
            i += 0x11223344;
        }
    }

    public static void main(final String[] args) throws Exception
    {
        Thread backgroundThread = new Thread(Main::run);
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopFalg = true;
    }
}
