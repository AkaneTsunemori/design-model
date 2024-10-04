package com.shiro.tank.entity.decorator;

import com.shiro.tank.entity.abstractfactory.GameObject;

import java.awt.Graphics;

public abstract class GameObjectDecorator extends GameObject {
    GameObject gameObject;

    @Override
    public void paint(Graphics g) {
        if(gameObject.isAlive())
        gameObject.paint(g);
    }
    public GameObject getGameObject(){
        return gameObject;
    }
}
