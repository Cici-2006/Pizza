package com.PizzaStore;

public class Main2 {
    public static void main(String[] args)throws Exception {
        SliceOHeaven sliceOHeaven = new SliceOHeaven();
        sliceOHeaven.takeOder("DEF-SOH-099","set meal",15.00,"orange");
        sliceOHeaven.makePizza("Mozzarella Cheese","10","6-inch");
        sliceOHeaven.processCardPayment("12345678902233");
        sliceOHeaven.specialOfTheDay("cheese pizza","pineapple","5");
    }

}
