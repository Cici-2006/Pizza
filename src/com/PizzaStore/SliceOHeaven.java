package com.PizzaStore;

public class SliceOHeaven {

    public String storeName;
    public String storeAdress;
    public String storeEmail;
    public String storePhone;
    public String storeMenu;
    public String pizzaPrice;
    private String pizzaIngredients = "Mozzarella Cheese";

    private String sides;
    private String drinks;

    private String oderID = "DEF-SOH-099";
    private double oderTotal = 15.00;

    public SliceOHeaven(String oderID,String pizzaIngredients,double oderTotal,String pizzaPrice,String sides,String drinks){
        this.oderID = oderID;
        this.pizzaIngredients = pizzaIngredients;
        this.oderTotal = oderTotal;
        this.drinks = drinks;
        this.sides = sides;
    }

    public SliceOHeaven() {

    }

    public  String getOderID(){
        return oderID;
    }
    public void setOderID(String id){
        oderID = id;
    }
    public String getPizzaIngredients(){
        return pizzaIngredients;
    }
    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients = pizzaIngredients;
    }
    public double getOderTotal(){
        return oderTotal;
    }
    public  void setOderTotal(double oderTotal){
        this.oderTotal = oderTotal;
    }
    public String getDrinks(){
        return drinks;
    }
    public void setDrinks(String drinks){
        this.drinks = drinks;
    }
    public String getSides(){
        return  sides;
    }
    public void setSides(String sides){
        this.sides = sides;
    }

    public  void takeOder(String id, String menu, double total ,String Drinks){
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
        pizzaPrice = price;
        sides = side;
        System.out.println("Make Pizza");
        System.out.println("ingredients:"+" "+ pizzaIngredients);
        System.out.println("sides:" +" "+ sides );
        System.out.println("pizzaPrize:"+" "+pizzaPrice);

    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");

        System.out.println("Oder ID:" + oderID);
        System.out.println("Oder menu:" + storeMenu);
        System.out.println("your drinks:" + drinks);
        System.out.println("Oder Total:" + oderTotal);

    }
}



