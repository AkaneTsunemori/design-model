package com.shiro.tank.entity.abstractfactory;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Graphics;

@NoArgsConstructor
@Data
public abstract class GameObject implements ILive {
    GameObject pre;
    GameObject next;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public boolean alive = true;
    public GameObject(int x,int y, int width,int height){
        this.x =x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public GameObject getGameObject(){
        return this;
    }

    public void paint(Graphics g) {
    }
    public void remove(){
        GameObject pre = this.getPre();
        GameObject next = this.getNext();
        pre.setNext(next);
        next.setPre(pre);
    }
}
