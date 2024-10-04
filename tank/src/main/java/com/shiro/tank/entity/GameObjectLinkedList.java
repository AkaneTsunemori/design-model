package com.shiro.tank.entity;

import com.shiro.tank.entity.abstractfactory.GameObject;
import lombok.Data;


@Data
public class GameObjectLinkedList {
    private GameObject hair = new GameObject() {};
    private GameObject tail = new GameObject() {};
    public GameObjectLinkedList(){
        hair.setNext(tail);
        tail.setPre(hair);
    }

    public void add(GameObject go) {
        GameObject pre = tail.getPre();
        pre.setNext(go);
        go.setPre(pre);
        go.setNext(tail);
        tail.setPre(go);
    }
    public GameObject getFirst(){
        return hair.getNext();
    }
    public void remove(GameObject go){
        go.remove();
    }
}
