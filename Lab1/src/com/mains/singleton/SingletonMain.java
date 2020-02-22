package com.mains.singleton;

import java.util.Properties;

public class SingletonMain {

    public static void main(String[] args) {
	    Singleton singleton = Singleton.getInstance();
	    Properties properties = singleton.getProperties();
	    System.out.println(properties.getProperty("login"));
	    System.out.println(properties.getProperty("password"));
	    System.out.println(properties.getProperty("homedir"));
    }
}
