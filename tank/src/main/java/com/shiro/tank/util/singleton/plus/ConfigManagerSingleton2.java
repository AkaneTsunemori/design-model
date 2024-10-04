package com.shiro.tank.util.singleton.plus;

import com.shiro.tank.util.singleton.ConfigManagerSingleton;

import java.io.IOException;
import java.util.Properties;

//静态内部类的线程安全是有jvm保证的,加载class只会加载一次
public class ConfigManagerSingleton2 {
    private static Properties properties = new Properties();

    private ConfigManagerSingleton2() {
        try {
            properties.load(ConfigManagerSingleton.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String get(String key) {
        return Inner.get(key);
    }

    static class Inner {
        static ConfigManagerSingleton2 configManagerSingleton2 = new ConfigManagerSingleton2();

        public static ConfigManagerSingleton2 getConfigManagerSingleton2() {
            return configManagerSingleton2;
        }

        public static String get(String key) {
            return (String) properties.get(key);
        }
    }
}
