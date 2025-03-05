package com.PizzaStore;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SliceOHeaven {
    private String ing1;
    private String ing2;
    private String ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String wantDiscount;

    private int cardLength;
    private String blacklistNumber = new String("12345678901234");
    private String pizzaOfTheDay;
    private String sideOfTheDay;
    private String specialOfTheDay;
    private long cardNumber;
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
    public void specialOfTheDay(String pizzaOfTheDay,String sideOfTheDay,String specialPrice){

        System.out.println("Today's special offer:");
        System.out.println("Pizza of the day:"+pizzaOfTheDay);
        System.out.println("Side of the day:"+sideOfTheDay);
        System.out.println("Specialprice:"+specialPrice);
    }

    public  void takeOder(){
        this.oderID= oderID;
        this.oderTotal = oderTotal;
        this.storeMenu = storeMenu;
        this.drinks = drinks;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza(use spaces to separate ingredients):");
        String temp = scanner.nextLine();

        ing1 = temp.split(" ")[0];
        ing2 = temp.split(" ")[1];
        ing3 = temp.split(" ")[2];


        System.out.println("Enter size of pizza(Small,Medium,Large):");
        pizzaSize = scanner.nextLine();

        System.out.println("Do you want extra cheese(Y/N):");
        extraCheese = scanner.nextLine();

        System.out.println("Enter one side dish(Calzone,Garlic bread,None):");
        sideDish = scanner.nextLine();

        System.out.println("Enter drinks (Cold Coffee,Cocoa Drink,Coke,None):");
        drinks = scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order?(Y/N):");
        wantDiscount = scanner.nextLine();
        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        }
        makeCardPayment();
    System.out.println("Oder accepted!");
    System.out.println("Oder is being prepared");

    try{
        this.makePizza(ing1 + " " + ing2 + " " + ing3,"10",pizzaSize);
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
    public void isItYourBirthday(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birthdate (yyyy-MM-dd)");
        String birthdate = input.nextLine();
        LocalDate dob = LocalDate.parse( birthdate);
        LocalDate now = LocalDate.now();
        Period age = Period.between(dob,now);
        if (age.getYears()<18 && dob.getMonth()==now.getMonth() && dob.getDayOfMonth()==now.getDayOfMonth()) {
            System.out.println("Congratulations!You pay only half the price for your order.");
        }else {
            System.out.println("Too bad!YOu do not meet the conditions to get our 50% discount.");
        }
    }
    public void makeCardPayment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the card's expiry date(yyyy-MM):");
        String expiryDate = scanner.nextLine();
        System.out.println("Enter the card's cvv:");
        this.cvv = scanner.nextInt();
        System.out.println("cvv:"+ this.cvv);

        processCardPayment(cardNumber, cvv, expiryDate);

    }
    public void processCardPayment(long cardNumber,int cvv,String expiryDate){
        this.cardNumber = cardNumber;
        cardLength = Long.toString(cardNumber).length();
        if(cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }
        int firstCardDigit= Integer.parseInt(Long.toString(cardNumber).substring(0,1));
        if(Long.toString(cardNumber).equals(blacklistNumber)){
            System.out.println("Card is blacklisted.Please use another card");
            makeCardPayment();
            return;
        }

        String lastFourDigits = String.valueOf(Integer.parseInt(Long.toString(cardNumber).substring(9, 13)));
        cardNumberToDisplay = firstCardDigit+"*********"+lastFourDigits;
        System.out.println(cardNumberToDisplay);

        System.out.println("Card Number:"+ cardNumber);
        System.out.println("Expiry DAte:"+ expiryDate);
        System.out.println("Payment successful!Thank you for your order.");
    }



}







