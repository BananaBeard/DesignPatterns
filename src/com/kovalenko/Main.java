package com.kovalenko;

import com.kovalenko.patterns.behavioral.iterator.FoodContainer;
import com.kovalenko.patterns.behavioral.iterator.Iterator;
import com.kovalenko.patterns.behavioral.memento.Caretaker;
import com.kovalenko.patterns.behavioral.memento.Originator;
import com.kovalenko.patterns.behavioral.strategy.Context;
import com.kovalenko.patterns.behavioral.strategy.StrategyAdd;
import com.kovalenko.patterns.behavioral.strategy.StrategyMultiply;
import com.kovalenko.patterns.behavioral.strategy.StrategySubstract;
import com.kovalenko.patterns.creational.Singleton;
import com.kovalenko.patterns.creational.Student;
import com.kovalenko.patterns.creational.factorymethod.Creator;
import com.kovalenko.patterns.creational.factorymethod.CreatorA;
import com.kovalenko.patterns.creational.factorymethod.CreatorB;
import com.kovalenko.patterns.creational.factorymethod.Product;
import com.kovalenko.patterns.structural.proxy.MathInterface;
import com.kovalenko.patterns.structural.proxy.MathProxy;

public class Main {

    public static void main(String[] args) {

        System.out.println("===========CREATIONAL PATTERNS==========");

        singletonTest();
        fabricMethodTest();
        builderTest();

        System.out.println("========================================\n\n");

        System.out.println("===========STRUCTURAL PATTERNS==========");
        proxyTest();
        System.out.println("========================================\n\n");

        System.out.println("===========BEHAVIORAL PATTERNS==========");
        mementoTest();
        iteratorTest();
        strategyTest();
        System.out.println("========================================\n\n");
    }

    static void singletonTest() {
        System.out.println("1. Singleton test:\n");
        System.out.println(Singleton.getInstance().getMessage() + " " + Singleton.getInstance().getNumber());
        System.out.println();
    }

    static void fabricMethodTest() {
        System.out.println("2. Fabric method test:\n");
        Creator[] creators = {new CreatorA(), new CreatorB()};
        for (Creator creator: creators) {
            Product product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
        System.out.println();
    }

    static void builderTest() {
        System.out.println("3. Builder test:\n");
        Student student = Student.getBuilder().firstName("Kostya").secondName("Kovalenko").mark(4).build();
        System.out.println(student);
    }

    static void mementoTest() {
        System.out.println("1. Memento test:\n");
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("state one");
        System.out.printf("State is %s\n", originator.getState());
        caretaker.setMemento(originator.saveState());

        originator.setState("state two");
        System.out.printf("State is %s\n", originator.getState());

        originator.restoreState(caretaker.getMemento());
        System.out.printf("State is %s\n", originator.getState());
        System.out.println();
    }

    static void iteratorTest() {
        System.out.println("2. Iterator test:\n");

        FoodContainer foodContainer = new FoodContainer();

        for (Iterator iter = foodContainer.getIterator(); iter.hasNext();) {
            String foodName = (String) iter.next();
            System.out.println(foodName);
        }
        System.out.println();
    }

    static void strategyTest() {
        System.out.println("3. Strategy test:\n");

        Context context = new Context();

        context.setStrategy(new StrategyAdd());
        System.out.println("Add result = " + context.executeStrategy(3,4));

        context.setStrategy(new StrategySubstract());
        System.out.println("Substraction result = " + context.executeStrategy(3,4));

        context.setStrategy(new StrategyMultiply());
        System.out.println("Multiplication result = " + context.executeStrategy(3,4));
        System.out.println();
    }

    static void proxyTest() {
        System.out.println("1. Proxy test:\n");

        MathInterface p = new MathProxy();

        System.out.println("3 + 4 = " + p.add(3, 4));
        System.out.println("3 - 4 = " + p.sub(3, 4));
        System.out.println("3 * 4 = " + p.mul(3, 4));
        System.out.println("3 / 4 = " + p.div(3, 4));
        System.out.println();
    }
}
