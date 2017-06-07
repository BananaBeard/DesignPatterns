package com.kovalenko.patterns.creational;

public class Singleton {
    private static Singleton instance;

    private int number = 1000;
    private String message = "The number is";
    private Singleton(){}

    public static Singleton getInstance() {
        if (null==instance) {
            instance = new Singleton();
        }
        return instance;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
