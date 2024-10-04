package com.shiro.tank.entity;

import com.shiro.tank.entity.abstractfactory.*;
import com.shiro.tank.entity.abstractfactory.impl.BaseSeriesFactory;
import com.shiro.tank.entity.cannon.IFireStrategy;
import com.shiro.tank.entity.chainOfResponsibility.BulletTankCollider;
import com.shiro.tank.entity.chainOfResponsibility.ColliderChain;
import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import com.shiro.tank.util.Const;
import com.shiro.tank.util.ResourceManager;
import com.shiro.tank.util.singleton.ConfigManagerSingleton;
import com.shiro.tank.util.singleton.plus.ConfigManagerSingleton3;
import lombok.Data;

import java.awt.Graphics;

@Data
public class GameModelMediator {
    BaseTank mytank;
    GameObjectLinkedList gameObjectList = new GameObjectLinkedList();
    ISeriesFactory seriesFactory;
    ColliderChain chain = new ColliderChain();
    private static GameModelMediator gameModelMediator = new GameModelMediator();
    boolean  init = false;

    private GameModelMediator() {
        while(ResourceManager.init==false){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.seriesFactory = new BaseSeriesFactory();
        chain.addCollider(new BulletTankCollider());
        try {
            mytank = new BaseTank(200, 200, Direction.DOWN, 5, this, Group.FRIEND, (IFireStrategy) Class.forName(ConfigManagerSingleton.get("myTankFire")).getDeclaredConstructor().newInstance(), seriesFactory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        initEnemy(Integer.parseInt(ConfigManagerSingleton3.INSTANCE.get("initTankCount")));
        init = true;
    }

    public static GameModelMediator getGameModelMediator() {
        return gameModelMediator;
    }

    public void paint(Graphics g) {
        if(!init){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        mytank.paint(g);
        gameObjectPrint(g);
    }

    public void addExplosion(int x, int y) {
        gameObjectList.add(seriesFactory.createExplosion(x, y));
    }

    public void initEnemy(int enemyNum) {
        for (int i = 0; i < enemyNum; i++) {
            gameObjectList.add(newEnemyTank());
        }
    }

    public GameObject newEnemyTank() {
        try {
            return seriesFactory.createTank(Const.RANDOM.nextInt(1400),
                    Const.RANDOM.nextInt(1200), Direction.valueOf(Const.RANDOM.nextInt(4)),
                    4, this, Group.ENEMY,
                    (IFireStrategy) Class.forName(ConfigManagerSingleton.get("enemyFire")).getDeclaredConstructor().newInstance()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void gameObjectPrint(Graphics g) {
        GameObject first = gameObjectList.getFirst();
        GameObject second = first.getNext();
        while (second != gameObjectList.getTail()) {
            while (second != gameObjectList.getTail()) {
                chain.collider(first, second);
                second = second.getNext();
            }
            first = first.getNext();
            second = first.getNext();
        }
        first = gameObjectList.getFirst();
        while (first.getNext() != gameObjectList.getTail()) {
            if (first.isAlive()&&first.getGameObject().isAlive()) {
                first.paint(g);
            } else {
                first.remove();
            }
            first = first.getNext();
        }
    }

    public void myTankFire() {
        mytank.fire();
    }

    public void myTankStop() {
        mytank.setMoving(false);
    }

    public void myTankMoving() {
        mytank.setMoving(true);
    }

    public void setMyTankDirection(Direction direction) {
        mytank.setDirection(direction);
    }

    public void addGameObject(GameObject go) {
        gameObjectList.add(go);
    }
}
