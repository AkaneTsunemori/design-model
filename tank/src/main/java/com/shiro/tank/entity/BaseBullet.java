package com.shiro.tank.entity;

import com.shiro.tank.entity.abstractfactory.GameObject;
import com.shiro.tank.entity.abstractfactory.IBullet;
import com.shiro.tank.util.Const;
import com.shiro.tank.util.ResourceManager;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import lombok.Data;

import java.awt.Graphics;


@Data
public class BaseBullet extends  IBullet {
    private static final int SPEED = 10;
    private Direction direction;
    private GameModelMediator gameModel;
    private Group group;

    public BaseBullet(int x, int y, Direction direction, GameModelMediator gameModel, Group group) {
        super(x,y,Const.BULLET_WIDTH,Const.BULLET_HEIGHT);

        if(direction==Direction.LEFT||direction==Direction.RIGHT){
            width = Const.BULLET_HEIGHT;
            height = Const.BULLET_WIDTH;
        }
        this.gameModel = gameModel;
        this.group = group;
        this.direction = direction;
    }

    public void paint(Graphics g) {
        switch (direction){
            case DOWN:
                g.drawImage(ResourceManager.bulletD,getX(),getY(),null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU,getX(),getY(),null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL,getX(),getY(),null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR,getX(),getY(),null);
                break;
        }
        move();
    }

    public void move() {
        switch (direction){
            case LEFT:
                setX(getX()-SPEED);
                break;
            case RIGHT:
                setX(getX()+SPEED);
                break;
            case UP:
                setY(getY()-SPEED);
                break;
            case DOWN:
                setY(getY()+SPEED);
                break;
            default:
                break;
        }
        if(getX()<0||getY()<0||getX()> Const.GAME_WIDTH||getY()>Const.GAME_HIGH){
            alive = false;
        }
    }
}
