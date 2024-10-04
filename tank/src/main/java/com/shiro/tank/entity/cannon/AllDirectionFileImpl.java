package com.shiro.tank.entity.cannon;

import com.shiro.tank.entity.GameModelMediator;
import com.shiro.tank.entity.abstractfactory.ISeriesFactory;
import com.shiro.tank.entity.abstractfactory.ITank;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import com.shiro.tank.util.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllDirectionFileImpl implements IFireStrategy{
    private ITank tank;
    @Override
    public void fire() {
        GameModelMediator gameModel = GameModelMediator.getGameModelMediator();
        Group group = tank.getGroup();
        ISeriesFactory seriesFactory = gameModel.getSeriesFactory();
        gameModel.addGameObject(seriesFactory.createBullet(tank.getX() + Const.TANK_WIDTH / 2, tank.getY(), Direction.UP, gameModel, group));
        gameModel.addGameObject(seriesFactory.createBullet(tank.getX() + Const.TANK_WIDTH / 2, tank.getY() + Const.TANK_HEIGHT, Direction.DOWN, gameModel, group));
        gameModel.addGameObject(seriesFactory.createBullet(tank.getX(), tank.getY() + Const.TANK_HEIGHT / 2, Direction.LEFT, gameModel, group));
        gameModel.addGameObject(seriesFactory.createBullet(tank.getX() + Const.TANK_WIDTH, tank.getY() + Const.TANK_WIDTH / 2, Direction.RIGHT, gameModel, group));
    }
}
