package com.shiro.tank.entity;

import com.shiro.tank.util.Const;
import com.shiro.tank.enumeration.Direction;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame extends java.awt.Frame {


    public Frame() throws Exception {
        setSize(Const.GAME_WIDTH, Const.GAME_HIGH);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new Frame.MyKeyListerer());
        //监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //会被系统自动调用,窗口最小化 重新拉起的时候系统会调用
    @Override
    public void paint(Graphics g) {
        GameModelMediator.getGameModelMediator().paint(g);
    }


    class MyKeyListerer extends KeyAdapter {
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = true;
                    setDirection();
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    setDirection();
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    setDirection();
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    setDirection();
                    break;
                case KeyEvent.VK_SPACE:
                    GameModelMediator.getGameModelMediator().myTankFire();
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            GameModelMediator.getGameModelMediator().myTankStop();
            bl = false;
            br = false;
            bu = false;
            bd = false;
        }


        public void setDirection() {
            GameModelMediator.getGameModelMediator().myTankMoving();
            if (bl) {
                GameModelMediator.getGameModelMediator().setMyTankDirection(Direction.LEFT);
            }
            if (br) {
                GameModelMediator.getGameModelMediator().setMyTankDirection(Direction.RIGHT);
            }
            if (bu) {
                GameModelMediator.getGameModelMediator().setMyTankDirection(Direction.UP);
            }
            if (bd) {
                GameModelMediator.getGameModelMediator().setMyTankDirection(Direction.DOWN);
            }
        }
    }


}
