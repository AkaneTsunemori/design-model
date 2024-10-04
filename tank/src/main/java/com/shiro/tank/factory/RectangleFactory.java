package com.shiro.tank.factory;

import com.shiro.tank.util.Const;
import java.awt.Rectangle;

public class RectangleFactory {
    private static volatile Rectangle tankRectangle;
    private static volatile Rectangle bulletRectangle;

    public static Rectangle getTankRectangle(int x,int y) {
        if(tankRectangle==null){
            synchronized (RectangleFactory.class){
                if(tankRectangle==null){
                    tankRectangle = new Rectangle(x,y, Const.TANK_WIDTH,Const.TANK_HEIGHT);
                    return tankRectangle;
                }
            }
        }
        tankRectangle.x = x;
        tankRectangle.y = y;
        return tankRectangle;
    }

    public static Rectangle getBulletRectangle(int x,int y) {
        if(bulletRectangle==null){
            synchronized (RectangleFactory.class){
                if(bulletRectangle==null){
                    bulletRectangle = new Rectangle(x,y, Const.BULLET_WIDTH,Const.BULLET_HEIGHT);
                    return bulletRectangle;
                }
            }
        }
        bulletRectangle.x = x;
        bulletRectangle.y = y;
        return bulletRectangle;
    }
}
