package com.shiro.tank.entity.abstractfactory.impl;


import com.shiro.tank.entity.GameModelMediator;
import com.shiro.tank.entity.abstractfactory.*;
import com.shiro.tank.entity.cannon.IFireStrategy;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;

public class ModernSeriesFactory implements ISeriesFactory {

    @Override
    public GameObject createBullet(int x, int y, Direction direction, GameModelMediator gameModel, Group group) {
        return null;
    }

    @Override
    public GameObject createTank(int x, int y, Direction direction, int speed, GameModelMediator gameModel, Group group, IFireStrategy iFireStrategy) {
        return null;
    }

    @Override
    public GameObject createExplosion(int x, int y) {
        return null;
    }
}
