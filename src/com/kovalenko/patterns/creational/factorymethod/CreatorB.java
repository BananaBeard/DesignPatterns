package com.kovalenko.patterns.creational.factorymethod;

public class CreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ProductB();
    }
}
