package com.shiro.tank.entity.decorator;

import com.shiro.tank.entity.abstractfactory.GameObject;

import java.awt.*;

public class RectDecorator extends GameObjectDecorator{
    public RectDecorator(GameObject gameObject){
        this.gameObject = gameObject;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawRect(gameObject.getX(), gameObject.getY(), gameObject.getWidth(),gameObject.getHeight());
    }
}
