package com.shiro.tank.entity.chainOfResponsibility;

import com.shiro.tank.entity.abstractfactory.GameObject;
import lombok.Data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Data
public class ColliderChain implements Collider {
    List<Collider> list = new LinkedList<>();

    public void addCollider(Collider collider) {
        list.add(collider);
    }

    @Override
    public boolean collider(GameObject go1, GameObject go2) {
        Iterator<Collider> iterator = list.iterator();
        boolean state = true;
        while (state && iterator.hasNext()) {
            Collider next = iterator.next();
            state = next.collider(go1, go2);
        }
        return state;
    }
}
