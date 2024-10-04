package com.shiro.tank.entity.cannon;

import lombok.Setter;

public class CannonContext {
    @Setter
    IFireStrategy iFireStrategy;
    public void execute(){
        iFireStrategy.fire();
    }

}
