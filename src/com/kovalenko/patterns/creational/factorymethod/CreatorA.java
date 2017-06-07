package com.kovalenko.patterns.creational.factorymethod;

public class CreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
