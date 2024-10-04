package com.shiro.tank.util;

import com.shiro.tank.util.singleton.ConfigManagerSingleton;

import java.util.Random;

public class Const {
    public static final int GAME_WIDTH = Integer.parseInt(ConfigManagerSingleton.get("gameWidth"));
    public static final int GAME_HIGH = Integer.parseInt(ConfigManagerSingleton.get("gameHeight"));
    public static int TANK_WIDTH;
    public static int TANK_HEIGHT;
    public static int BULLET_WIDTH;
    public static int BULLET_HEIGHT;
    public static int EXPLOSION_WIDTH;
    public static int EXPLOSION_HEIGHT;
    public static Random RANDOM = new Random();
}
