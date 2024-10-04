package com.shiro.tank.entity.cannon;

import com.shiro.tank.entity.BaseBullet;
import com.shiro.tank.entity.GameModelMediator;
import com.shiro.tank.entity.abstractfactory.ITank;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import com.shiro.tank.util.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeBulletFireImpl implements IFireStrategy {
    private ITank tank;
    @Override
    public void fire() {
        Direction direction = tank.getDirection();
        GameModelMediator gameModel = GameModelMediator.getGameModelMediator();
        Group group = tank.getGroup();
        gameModel.addGameObject(new BaseBullet(tank.getX() + Const.TANK_WIDTH / 2, tank.getY(), direction, gameModel, group));
        gameModel.addGameObject(new BaseBullet(tank.getX() + Const.TANK_WIDTH / 2, tank.getY() + Const.TANK_HEIGHT, direction, gameModel, group));
        gameModel.addGameObject(new BaseBullet(tank.getX(), tank.getY() + Const.TANK_HEIGHT / 2, direction, gameModel, group));
        gameModel.addGameObject(new BaseBullet(tank.getX() + Const.TANK_WIDTH, tank.getY() + Const.TANK_WIDTH / 2, direction, gameModel, group));
    }
}
