package com.kovalenko.patterns.structural.proxy;

public class MathProxy implements MathInterface {

    private Math math;

    @Override
    public double add(double a, double b) {
        if(math == null) {
            math = new Math();
        }
        return math.add(a, b);
    }

    @Override
    public double sub(double a, double b) {
        if(math == null) {
            math = new Math();
        }
        return math.sub(a, b);
    }

    @Override
    public double mul(double a, double b) {
        if(math == null) {
            math = new Math();
        }
        return math.mul(a, b);
    }

    @Override
    public double div(double a, double b) {
        if(math == null) {
            math = new Math();
        }
        return math.div(a, b);
    }
}
