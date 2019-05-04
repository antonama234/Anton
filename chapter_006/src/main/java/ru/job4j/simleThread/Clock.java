package ru.job4j.simleThread;

/**
Visibility of Shared Objects.
 Здесь есть два стека. У каждого стека свой кэш. В методе run переменная isCancel при первом использовании будет
 помещена в кэш созданного нами стека. Вызов метода cancel из другого потока поменяет значение переменной isCancel в
 памяти RAM, но не в кэше остальных стеков.
 */

public class Clock implements Runnable {
    private boolean isCancel = false;

    public void cancel() {
        this.isCancel = true;
    }

    public void run() {
        while (!this.isCancel) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tik");
        }
    }
}
