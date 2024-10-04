package com.shiro.tank.entity.abstractfactory;

import com.shiro.tank.enumeration.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class IBullet extends GameObject{
    public IBullet(int x,int y, int width,int height){
        super(x,y,width,height);
    }
    public  void move(){}
    public Group getGroup(){
        return null;
    }
}
