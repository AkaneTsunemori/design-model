package com.shiro.tank.entity;

import com.shiro.tank.entity.abstractfactory.GameObject;
import com.shiro.tank.entity.abstractfactory.ISeriesFactory;
import com.shiro.tank.entity.abstractfactory.ITank;
import com.shiro.tank.entity.cannon.CannonContext;
import com.shiro.tank.entity.cannon.IFireStrategy;
import com.shiro.tank.util.Const;
import com.shiro.tank.util.ResourceManager;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Graphics;

@Data
public class BaseTank extends  ITank {
    private Direction direction;
    private final int SPEED;
    private boolean moving = true;
    private GameModelMediator gameModel;

    private Group group;
    private CannonContext cannonContext = new CannonContext();
    private ISeriesFactory seriesFactory;
    public BaseTank(int x, int y, Direction direction, int speed, GameModelMediator gameModel, Group group, IFireStrategy iFireStrategy, ISeriesFactory seriesFactory) {
        super(x, y, Const.TANK_WIDTH, Const.TANK_HEIGHT);
        this.direction = direction;
        SPEED = speed;
        this.gameModel = gameModel;
        alive = true;
        this.group = group;
        cannonContext.setIFireStrategy(iFireStrategy);
        iFireStrategy.setTank(this);
        this.seriesFactory = seriesFactory;
    }

    public void paint(Graphics g) {
        switch (direction) {
            case LEFT:
                if (group.equals(Group.FRIEND)) {
                    g.drawImage(ResourceManager.friendTankL, x, y, null);
                } else {
                    g.drawImage(ResourceManager.enemyTankL, x, y, null);
                }
                break;
            case RIGHT:
                if (group.equals(Group.FRIEND)) {
                    g.drawImage(ResourceManager.friendTankR, x, y, null);
                } else {
                    g.drawImage(ResourceManager.enemyTankR, x, y, null);
                }
                break;
            case UP:
                if (group.equals(Group.FRIEND)) {
                    g.drawImage(ResourceManager.friendTankU, x, y, null);
                } else {
                    g.drawImage(ResourceManager.enemyTankU, x, y, null);
                }
                break;
            case DOWN:
                if (group.equals(Group.FRIEND)) {
                    g.drawImage(ResourceManager.friendTankD, x, y, null);
                } else {
                    g.drawImage(ResourceManager.enemyTankD, x, y, null);
                }
                break;
            default:
                break;

        }
        if (group.equals(Group.ENEMY)) {
            if (Const.RANDOM.nextInt(100) > 95) {
                direction = Direction.valueOf(Const.RANDOM.nextInt(4));
            }
        }
        move();
        if (Const.RANDOM.nextInt(100) > 90 && group == Group.ENEMY) {
            fire();
        }
        boundCheck();
    }

    private void boundCheck() {
        if (x < 0) x = 0;
        if (y < 30) y = 30;
        if (x > Const.GAME_WIDTH - Const.TANK_WIDTH) x = Const.GAME_WIDTH - Const.TANK_WIDTH;
        if (y > Const.GAME_HIGH - Const.TANK_HEIGHT) y = Const.GAME_HIGH - Const.TANK_HEIGHT;
    }

    public void move() {
        if (!moving) {
            return;
        }
        switch (direction) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        cannonContext.execute();
    }
}
