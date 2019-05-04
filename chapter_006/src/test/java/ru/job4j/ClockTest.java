package ru.job4j;

import org.junit.Test;
import ru.job4j.simleThread.Clock;

public class ClockTest {
    @Test
    public void test() throws InterruptedException {
        Clock clock = new Clock();
        Thread thread = new Thread(clock);
        thread.start();
        Thread.sleep(2000);
        clock.cancel();
    }
}
