package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            while (true) {
                if (this.rect.getX() == 299) {
                    count = -1;
                }
                if (this.rect.getX() == 1) {
                    count = 1;
                }
                this.rect.setX(this.rect.getX() + count);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
