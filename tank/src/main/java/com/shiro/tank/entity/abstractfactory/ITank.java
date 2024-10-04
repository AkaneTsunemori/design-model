package com.shiro.tank.entity.abstractfactory;

import com.shiro.tank.enumeration.Direction;
import com.shiro.tank.enumeration.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class ITank extends GameObject {
    void move() {
    }
    void fire() {
    }
    void setMoving(boolean moving) {
    }
    void setDirection(Direction direction) {
    }
    public Group getGroup(){
        return null;
    }
    public Direction getDirection(){
        return null;
    }
    public ITank(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

}
