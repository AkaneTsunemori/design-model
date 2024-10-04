package com.shiro.tank;

import com.shiro.tank.entity.Frame;

public class Main {
    public static void main(String[] args) throws Exception {
        java.awt.Frame f = new Frame();
        while (true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}

//GameModel