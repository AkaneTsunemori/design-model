package com.shiro.tank.util.singleton;

import java.io.IOException;
import java.util.Properties;

public class ConfigManagerSingleton {
    private static Properties properties = new Properties();
    private static volatile ConfigManagerSingleton configManager;
    private ConfigManagerSingleton(){
        try {
            properties.load(ConfigManagerSingleton.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String get(String key) {
        if (configManager == null) {
            synchronized (ConfigManagerSingleton.class) {
                if (configManager == null) {
                    configManager = new ConfigManagerSingleton();
                }
            }
        }
        return (String) properties.get(key);
    }
}
