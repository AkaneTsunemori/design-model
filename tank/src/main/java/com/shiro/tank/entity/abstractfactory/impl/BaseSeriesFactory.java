package com.shiro.tank.entity.abstractfactory.impl;

import com.shiro.tank.entity.*;
import com.shiro.tank.entity.abstractfactory.*;
import com.shiro.tank.entity.cannon.IFireStrategy;
import com.shiro.tank.entity.decorator.RectDecorator;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;

public class BaseSeriesFactory implements ISeriesFactory {
    @Override
    public GameObject createBullet(int x, int y, Direction direction, GameModelMediator gameModel, Group group) {
        return new RectDecorator(new BaseBullet(x,y,direction,gameModel,group));
    }

    @Override
    public GameObject createTank(int x, int y, Direction direction, int speed, GameModelMediator gameModel, Group group, IFireStrategy iFireStrategy) {
        return new RectDecorator(new BaseTank(x,y,direction,speed,gameModel,group,iFireStrategy,gameModel.getSeriesFactory()));
    }

    @Override
    public GameObject createExplosion(int x, int y) {
        return new RectDecorator(new BaseExplosion(x,y));
    }
}
