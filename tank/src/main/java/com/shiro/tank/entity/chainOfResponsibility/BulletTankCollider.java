package com.shiro.tank.entity.chainOfResponsibility;

import com.shiro.tank.entity.BaseBullet;
import com.shiro.tank.entity.BaseTank;
import com.shiro.tank.entity.GameModelMediator;
import com.shiro.tank.entity.abstractfactory.GameObject;
import com.shiro.tank.entity.abstractfactory.IBullet;
import com.shiro.tank.entity.abstractfactory.ITank;
import com.shiro.tank.factory.RectangleFactory;

import java.awt.*;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collider(GameObject go1, GameObject go2) {
        GameObject go1Inner = go1.getGameObject();
        GameObject go2Inner = go2.getGameObject();
        if (go1Inner instanceof ITank && go2Inner instanceof IBullet||go1Inner instanceof IBullet && go2Inner instanceof ITank) {
            Rectangle bulletRec = RectangleFactory.getBulletRectangle(go2Inner.getX(), go2Inner.getY());
            Rectangle enemyRec = RectangleFactory.getTankRectangle(go1Inner.getX(), go1Inner.getY());
            if (((ITank) go1Inner).getGroup() == ((IBullet) go2Inner).getGroup()) {
                return true;
            }
            if (bulletRec.intersects(enemyRec)) {
                go2Inner.setAlive(false);
                go1Inner.setAlive(false);
                go1.setAlive(false);
                go2.setAlive(false);
                GameModelMediator.getGameModelMediator().addExplosion(go1Inner.getX(), go1Inner.getY());
                return false;
            }
        }
        return true;
    }
}
