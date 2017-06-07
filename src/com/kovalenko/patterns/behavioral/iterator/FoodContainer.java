package com.kovalenko.patterns.behavioral.iterator;

public class FoodContainer implements Container {
    public String[] food = {"Pizza", "Cheeseburger", "Kebab", "Pasta"};

    @Override
    public Iterator getIterator() {
        return new FoodIterator();
    }

    private class FoodIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < food.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return food[index++];
            }
            return null;
        }
    }
}
