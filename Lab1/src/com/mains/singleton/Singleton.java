package com.mains.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Singleton {
    private static Singleton singleton;
    private Properties properties;

    private Singleton () {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("resources/config.properties")) {
            properties = new Properties();
            properties.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
