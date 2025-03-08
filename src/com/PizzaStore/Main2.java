package com.PizzaStore;

public class Main2 {
    public static void main(String[] args)throws Exception {
        SliceOHeaven sliceOHeaven = new SliceOHeaven();
        sliceOHeaven.specialOfTheDay("cheese pizza","pineapple","5");
        sliceOHeaven.takeOder();
        sliceOHeaven.makePizza("10");
        System.out.println(sliceOHeaven.toString());
    }

}
