package com.shiro.tank.util.singleton.plus;

import com.shiro.tank.util.singleton.ConfigManagerSingleton;

import java.io.IOException;
import java.util.Properties;

//枚举类没有构造方法
public enum ConfigManagerSingleton3 {
    INSTANCE;
    static Properties properties = new Properties();

    public String get(String key) {
        return (String) properties.get(key);
    }

    static {
        try {
            properties.load(ConfigManagerSingleton.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
