package com.shiro.tank.enumeration;

public enum Direction {
    LEFT(0),RIGHT(1),UP(2),DOWN(3);
    int value;

    Direction(int value) {
        this.value = value;
    }

    public static int getValue(Direction direction) {
        for (Direction cur : Direction.values()) {
            if (cur==direction){
                return cur.value;
            }
        }
        return -1;
    }
    public static Direction valueOf(int value){
        for (Direction cur : Direction.values()) {
            if (cur.value==value){
                return cur;
            }
        }
        return null;
    }
}
