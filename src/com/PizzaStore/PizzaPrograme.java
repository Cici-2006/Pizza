package com.PizzaStore;

public class PizzaPrograme {

    public String storeName;
    public String storeAdress;
    public String storeEmail;
    public String storePhone;
    public String storeMenu;
    private String pizzaIngredients;
    private String pizzaPrince;
    private String sides;
    private String drinks;

    private String oderID;
    private String oderTotal;

    public  void takeOder(String id, String menu, String total ,String Drinks){
    oderID = id;
    storeMenu = menu;
    drinks = Drinks;
    oderTotal = total;

    System.out.println("Oder accepted!");
    System.out.println("Oder is being prepared");

    try{
        Thread.sleep(5000);
    }catch (InterruptedException e){
        System.out.println("Oder is ready for pickup!");
    }
    System.out.println("Your order is ready！");

    printReceipt();
    }
    public void makePizza(String ingredients,String price,String side){
        pizzaIngredients = ingredients;
        pizzaPrince = price;
        sides = side;

        System.out.println("Make Pizza" );
        System.out.println("ingredients:"+" "+ pizzaIngredients);
        System.out.println("sides: "+ " "+ sides );
        System.out.println("pizzaPrize:"+" "+pizzaPrince);
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");

        System.out.println("Oder ID:" + oderID);
        System.out.println("Oder menu:" + storeMenu);
        System.out.println("your drinks:" + drinks);
        System.out.println("Oder Total:" + oderTotal);
    }
}



