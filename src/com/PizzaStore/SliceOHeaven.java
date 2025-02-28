package com.PizzaStore;

import java.util.Objects;

public class SliceOHeaven {
    private int cardLength;

    private String blacklistNumber = new String("12345678901234");
    private String pizzaOfTheDay;
    private String sideOfTheDay;
    private String specialOfTheDay;
    private String cardNumber;
    private String expiryDate;
    private int cvv;
    public  int firstCardDigit;
    public int lastFourDigits;
    public String cardNumberToDisplay;

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


    }
    public void makePizza(String ingredients,String price,String side){
        pizzaIngredients = ingredients;
        pizzaPrice = price;
        sides = side;
        printReceipt();

    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Oder ID:" + oderID);
        System.out.println("Oder menu:" + storeMenu);
        System.out.println("your drinks:" + drinks);
        System.out.println("Oder Total:" + oderTotal);
        System.out.println("Make Pizza");
        System.out.println("ingredients:"+" "+ pizzaIngredients);
        System.out.println("sides:" +" "+ sides );
        System.out.println("pizzaPrize:"+" "+pizzaPrice);
    }

    public  void processCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
        cardLength = cardNumber.length();
        if(cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }


        int firstCardDigit= Integer.parseInt(cardNumber.substring(0,1));


        if(cardNumber.equals(blacklistNumber)){
            System.out.println("Card is blacklisted.Please use another card");
        }

        String lastFourDigits = String.valueOf(Integer.parseInt(cardNumber.substring(10, 14)));
        cardNumberToDisplay = firstCardDigit+"*********"+lastFourDigits;
        System.out.println(cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay,String sideOfTheDay,String specialPrice){

        System.out.println("Today's special offer:");
        System.out.println("Pizza of the day:"+pizzaOfTheDay);
        System.out.println("Side of the day:"+sideOfTheDay);
        System.out.println("Specialprice:"+specialPrice);
    }
}







