package com.shiro.tank.entity;

import com.shiro.tank.entity.abstractfactory.IExplosion;
import com.shiro.tank.util.Const;
import com.shiro.tank.util.ResourceManager;
import lombok.Data;

import java.awt.Graphics;


@Data
public class BaseExplosion extends  IExplosion {
    int count = 0;

    public BaseExplosion(int x, int y) {
        setX(x);
        setY(y);
        setHeight(Const.EXPLOSION_HEIGHT);
        setWidth(Const.BULLET_WIDTH);
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explosion[count++],getX(),getY(), Const.EXPLOSION_WIDTH,Const.EXPLOSION_HEIGHT,null);
        if(count==16){
            super.alive = false;
        }
    }

}
