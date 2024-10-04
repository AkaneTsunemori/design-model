package com.shiro.tank.entity.chainOfResponsibility;

import com.shiro.tank.entity.abstractfactory.GameObject;

public interface Collider {
    boolean collider(GameObject go1,GameObject go2);
}
