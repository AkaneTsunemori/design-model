package com.shiro.tank.entity.cannon;

import com.shiro.tank.entity.abstractfactory.ITank;

public interface IFireStrategy {
    void fire();
    void setTank(ITank tank);
}
