package com.PizzaStore;

public class Main2 {
    public static void main(String[] args)throws Exception {
        SliceOHeaven sliceOHeaven = new SliceOHeaven();
        sliceOHeaven.takeOder();
        sliceOHeaven.makePizza("Mozzarella Cheese","10","6-inch");

        sliceOHeaven.specialOfTheDay("cheese pizza","pineapple","5");
    }

}
