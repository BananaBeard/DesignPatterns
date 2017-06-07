package com.kovalenko.patterns.behavioral.strategy;

public class StrategySubstract implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
