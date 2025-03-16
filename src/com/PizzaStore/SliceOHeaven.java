package com.PizzaStore;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    public int firstCardDigit;
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


    enum PizzaSelection {
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, Ham, Mozzarella, and extra cheese", 22),
        VEGGIE("Veggie", "Green peppers, onions,tomatoes,mushrooms,and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce,bacon,onion,green pepper,and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham,Italian sausage,beef, onions,green peppers,mushrooms, black olives, and extra cheese", 45);

      private final String pizzaName;
      private final String pizzaToppings;
      private final int price;

      PizzaSelection(String pizzaName,String pizzaToppings,int price){
          this.pizzaName = pizzaName;
          this.pizzaToppings = pizzaToppings;
          this.price = price;
      }

      public String getPizzaName(){
          return pizzaName;
      }
      public String getPizzaToppings(){
          return pizzaToppings;
      }
      public int getPrice(){
          return price;
      }
        @Override
        public String toString(){
            return "PizzaName: "+pizzaName+"\n"+
                    "PizzaToppings: "+pizzaToppings+"\n"+
                    "Price: "+price;
        }
}

enum PizzaToppings{
        HAM("Ham",2),
        PEPPERONI("Pepperoni",2),
        BEEF("Beef",2),
        CHICKEN("Chicken",2),
        SAUSAGE("Sausage",2),
        PINEAPPLE("Pineapple",1),
        ONION("Onion",0.5),
        TOMATOES("Tomatoes",0.4),
        GREEN_PEPPERS("Green Peppers",0.5),
        BLACk_OLIVES("Black Olives",0.5),
        SPINACH("Spinach",0.5),
        CHEDDAR_CHEESE("Cheddar Cheese",0.8),
        MOZZARELLA_CHEESE("Mozzarella Cheese",0.8),
        FETA_CHEESE("Feta Cheese",1),
        PARMESAN_CHEESE("Parmesan Cheese",1);

        private final String topping;
        private final double price;

        PizzaToppings(String topping,double price){
            this.topping = topping;
            this.price = price;
        }

        public String getTopping(){
            return topping;
        }
        public double getPrice(){
            return price;
        }
        @Override
    public String toString(){
            return "Topping: "+topping+"\n"+
                    "Price: "+price;
        }
}

enum PizzaSize{
        LARGE("Large",10),
        MEDIUM("Medium",5),
        SMALL("Small",0);

        private final String pizzaSize;
        private final double addToPizzaPrice;

        PizzaSize(String pizzaSize,double addToPizzaPrice){
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }

        public String getPizzaSize(){
            return pizzaSize;
        }
        public double getAddToPizzaPrice(){
            return addToPizzaPrice;
        }
        @Override
    public String toString(){
            return "PizzaSize: "+pizzaSize+"\n"+
                    "Add to Pizza Price: "+addToPizzaPrice;
        }
}

enum SideDish {
    CALZONE("Calzone", 15),
    CHICKEN_PUFF("Chicken Puff", 20),
    MUFFIN("Muffin", 12),
    NOTHING("NO side dish",0);

    private final String sideDishName;
    private final double addToPizzaPrice;

    SideDish(String sideDishName,double addToPizzaPrice){
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getSideDishName(){
        return sideDishName;
    }
    public double getAddToPizzaPrice(){
        return addToPizzaPrice;
    }
    @Override
    public String toString(){
        return "SideDish: "+sideDishName+"\n"+
                "Add to Pizza Price: "+addToPizzaPrice;
    }
}

enum Drinks {
    COCA_COLA("Coca Cola", 8),
    COCOA_DRINK("Cocoa Drink", 10),
    NOTHING("No drinks", 0);

    private final String drinkName;
    private final double addToPizzaPrice;

    Drinks(String drinkName, double addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }
    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }
    @Override
    public String toString() {
        return "DrinkName: "+drinkName+"\n"+
                "Add to Pizza Price: "+addToPizzaPrice;
    }
}

    private final double PIZZA_BASE_PRICE = 10.0;
    private double totalOderPrice = 0.0;
    private String[] pizzaOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];

    public SliceOHeaven(String oderID, String pizzaIngredients, double oderTotal, String pizzaPrice, String sides, String drinks) {
        this.oderID = oderID;
        this.pizzaIngredients = pizzaIngredients;
        this.oderTotal = oderTotal;
        this.drinks = drinks;
        this.sides = sides;
    }

    public SliceOHeaven() {

    }


    public String getOderID() {
        return oderID;
    }

    public void setOderID(String id) {
        oderID = id;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public double getOderTotal() {
        return oderTotal;
    }

    public void setOderTotal(double oderTotal) {
        this.oderTotal = oderTotal;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {

        System.out.println("Today's special offer:");
        System.out.println("Pizza of the day:" + pizzaOfTheDay);
        System.out.println("Side of the day:" + sideOfTheDay);
        System.out.println("Specialprice:" + specialPrice);
    }

    public void takeOder() {
        boolean continueTakingOder = true;
        int pizzaCount = 0;
        int sideDishCount = 0;
        int drinkCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (continueTakingOder && pizzaCount < 10){
        System.out.println("Welcome to Slice-O-Heaven.Here's what we serve:");
        int index = 1;
        for (PizzaSelection pizza : PizzaSelection.values()) {
            System.out.println(index + "." + pizza.toString());
            index++;
        }
        System.out.println(index + ".Customer Pizza with a maximum of 10 toppings that you choose:");
        System.out.println("Please enter your choice(1-6):");
        int choice = scanner.nextInt();

        StringBuilder pizzaDescription = new StringBuilder();
        double pizzaPrice = 0.0;

        if (choice >= 1 && choice <= 5) {
            PizzaSelection pizza = PizzaSelection.values()[choice - 1];
            pizzaDescription.append(pizza.getPizzaName());
            pizzaDescription.append(" Pizza with ");
            pizzaDescription.append(pizza.getPizzaToppings());
            pizzaDescription.append(", for €");
            pizzaPrice = pizza.getPrice();
        } else if (choice == 6) {
            pizzaDescription.append("Custom Pizza with ");
            pizzaPrice = PIZZA_BASE_PRICE;
            System.out.println("Available toppings:");
            for (PizzaToppings topping : PizzaToppings.values()) {
                System.out.println(topping);
            }
            System.out.print("Please enter your choice of toppings (1 - " + (PizzaToppings.values().length) + ") up to 10 toppings: ");
            int toppingsCount = 0;
            while (toppingsCount < 10) {
                int toppingChoice = scanner.nextInt();
                if (toppingChoice < 1 || toppingChoice > PizzaToppings.values().length) {
                    break;
                }
                PizzaToppings topping = PizzaToppings.values()[toppingChoice - 1];
                pizzaDescription.append(topping.getTopping());
                pizzaDescription.append(", ");
                pizzaPrice += topping.getPrice();
                toppingsCount++;
            }
            pizzaDescription.deleteCharAt(pizzaDescription.length() - 1);
            pizzaDescription.deleteCharAt(pizzaDescription.length() - 1);
        } else {
            System.out.println("Invalid choice, please try again.");
            continue;
        }

        System.out.println("Available sizes:");

        for (PizzaSize size : PizzaSize.values()) {
            System.out.println(size);
        }

        System.out.println("Please enter your choice of size(1-" + (PizzaSize.values().length) + "):");
        int pizzaSizesOrdered = scanner.nextInt();
        if (pizzaSizesOrdered < 1 || pizzaSizesOrdered > PizzaSize.values().length) {
            System.out.println("Invalid choice, please try again.");
            continue;
        }
        PizzaSize size = PizzaSize.values()[pizzaSizesOrdered - 1];
        pizzaDescription.append(", ");
        pizzaDescription.append(size.getPizzaSize());
        pizzaDescription.append(", for €");
        pizzaPrice += size.getAddToPizzaPrice();

        System.out.println("Available side dishes:");
        for (SideDish sideDish : SideDish.values()) {
            System.out.println(sideDish);
        }
        System.out.println("Please enter your choice of side dish(1-" + (SideDish.values().length) + "):");
        int sideDishOrdered = scanner.nextInt();
        if (sideDishOrdered < 1 || sideDishOrdered > SideDish.values().length) {
            System.out.println("Invalid choice, please try again.");
            continue;
        }
        SideDish dish = SideDish.values()[sideDishOrdered - 1];
        pizzaDescription.append(", ");
        pizzaDescription.append(dish.getSideDishName());
        pizzaDescription.append(", for €");
        pizzaPrice += dish.getAddToPizzaPrice();

        System.out.println("Available drinks:");
        for (Drinks drink : Drinks.values()) {
            System.out.println(drink);
        }
        System.out.println("Please enter your choice of drink(1-" + (Drinks.values().length) + "):");
        int drinksOrdered = scanner.nextInt();
        if (drinksOrdered < 1 || drinksOrdered > Drinks.values().length) {
            System.out.println("Invalid choice, please try again.");
            continue;
        }
        Drinks drink = Drinks.values()[drinksOrdered - 1];
        pizzaDescription.append(", ");
        pizzaDescription.append(drink.getDrinkName());
        pizzaDescription.append(", for €");
        pizzaPrice += drink.getAddToPizzaPrice();


        pizzaOrdered[pizzaCount] = pizzaDescription.toString();
        totalOderPrice += pizzaPrice;

        System.out.println("Do you want to add more?(Y/N):");
        scanner.nextLine();
        String continueTakingOderChoice = scanner.nextLine();
        if (!continueTakingOderChoice.equalsIgnoreCase("Y")) {
            continueTakingOder = false;
        }
        pizzaCount++;
    }

        int ingChoice1, ingChoice2, ingChoice3;


        System.out.println("Please pick any three of the following ingredients:");
        System.out.println("1.Mushroom\n2.Paprika\n3.Sun-dried tomatoes\n4.Chicken\n5.Pineapple\n");
        System.out.println("Enter any three choices(1,2,3,...)separated by spaces:");
        while (true) {
            Scanner input = new Scanner(System.in);
            String parts = scanner.nextLine();
            ingChoice1 = Integer.parseInt(parts.split(" ")[0]);
            ingChoice2 = Integer.parseInt(parts.split(" ")[1]);
            ingChoice3 = Integer.parseInt(parts.split(" ")[2]);
            if (parts.split(" ").length != 3) {
                System.out.println("Enter any three choices(1,2,3,...)separated by spaces:");
                continue;
            }
            if (ingChoice1 < 1 || ingChoice1 > 5) {
                continue;
            }
            if (ingChoice2 < 1 || ingChoice2 > 5) {
                continue;
            }
            if (ingChoice3 < 1 || ingChoice3 > 5) {
                continue;
            }
            break;
        }
        ing1 = null;
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
        }
        ing2 = null;
        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
        }
        ing3 = null;
        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
        }
        int sizeChoice;
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.println("What size should your pizza be?:");
            System.out.println("1.Large\n2.Medium\n3.Small\n");
            System.out.println("Enter only one choice(1, 2, 3):");
            sizeChoice = scanner.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= 3) {
                break;
            } else {
                System.out.println("Invalid choice.Please enter a valid choice.");
            }
        }
//        sizeChoice = scanner.nextInt();

        switch (sizeChoice) {
            case 1:
                pizzaSize  = "Large";
                break;
            case 2:
                pizzaSize  = "Medium";
                break;
            case 3:
                pizzaSize  = "Small";
                break;
        }


        System.out.println("Do you want extra cheese(Y/N):");
        extraCheese = scanner.nextLine();
        scanner.nextLine();

        int sideDishChoice;
        while (true) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1.Calzone\n2.Garlic bread\n3.Chicken puff\n4.Muffin\n5.Nothing for me\n");
            System.out.println("What would you like?Pick one(1, 2, 3,...):");
            sideDishChoice = scanner.nextInt();
            if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                break;
            } else {
                System.out.println("Invalid choice.Please enter a valid choice.");
            }
        }

        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Noting for me";
        }

        int drinkChoice;
        while (true) {
            System.out.println("Choose from one of the drinks below.We recommend Coca Cola:");
            System.out.println("1.Coca Cola\n2.Cold coffe\n3.Cococa Drink\n4.No drinks for me\n");
            System.out.println("Enter your choice:");
            drinkChoice = scanner.nextInt();
            if (drinkChoice >= 1 && drinkChoice <= 4) {
                break;
            } else {
                System.out.println("Invalid choice.Please enter a valid choice.");
            }
        }
        switch (drinkChoice) {
            case 1:
                drinks = "Coca Cola";
                break;
            case 2:
                drinks= "Cole Coffee";
                break;
            case 3:
                drinks ="Cococa Drink";
                break;
            case 4:
                drinks = "No drinks for me";
                break;

        }


        System.out.println("Would you like the chance to pay only half for your order?(Y/N):");
        scanner.nextLine();
        wantDiscount = scanner.nextLine();
        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        }
        makeCardPayment();

        System.out.println("Oder accepted!");
        System.out.println("Oder is being prepared");
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Oder is ready for pickup!");
        }
        System.out.println("Your order is ready！");

    }

    public void makePizza( String price) {

        pizzaPrice = price;

    }

    public void isItYourBirthday() {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Enter your birthdate (yyyy-MM-dd):");
        while (true) {
            String date = input.next();
            LocalDate birthdate;
            birthdate = LocalDate.parse(date, formatter);
            LocalDate now = LocalDate.now();
            if (birthdate.isBefore(now.minusYears(120)) || birthdate.isAfter(now.minusYears(5))) {
                System.out.println("Invalid date.You are either too young or too dead to order.Please enter a valid date.");
            } else {
                LocalDate dob = birthdate;
                now = LocalDate.now();
                Period age = Period.between(dob, now);
                if (age.getYears() < 18 && dob.getMonth() == now.getMonth() && dob.getDayOfMonth() == now.getDayOfMonth()) {
                    System.out.println("Congratulations!You pay only half the price for your order.");
                    break;
                 } else {
                    System.out.println("Too bad!You do not meet the conditions to get our 50% discount.");
                    break;
                }
            }
        }
    }

    public void makeCardPayment() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your 14-digit card number:");
        long cardNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter the card's cvv:");
        this.cvv = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Enter the card's expiry date(YYYY-MM-DD):");
            this.expiryDate = scanner.nextLine();
            LocalDate inputDate = LocalDate.parse(expiryDate, formatter);
            if (inputDate.isBefore(LocalDate.now())) {
                System.out.println("Invalid date.Your card has expired.Please enter a future date.");
                continue;
            } else {
                break;
            }
        }
        processCardPayment(cardNumber, cvv, expiryDate);
    }

    public void processCardPayment(long cardNumber, int cvv, String expiryDate) {
        Scanner scanner = new Scanner(System.in);
        this.cardNumber = cardNumber;
        while (true) {

            cardLength = Long.toString(this.cardNumber).length();
            if (cardLength == 14) {
                System.out.println("Card accepted");
            } else {
                System.out.println("Invalid card number.Please enter a valid 14-digit card number.");
                this.cardNumber = scanner.nextLong();
                scanner.nextLine();
                continue;
            }
            if (Long.toString(this.cardNumber).equals(blacklistNumber)) {
                System.out.println("Card is blacklisted.Please use another card");
                this.cardNumber = scanner.nextLong();
                scanner.nextLine();
                continue;
            }
            break;
        }
        int firstCardDigit = Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
        String lastFourDigits = String.valueOf(Integer.parseInt(Long.toString(cardNumber).substring(10, 14)));
        cardNumberToDisplay = firstCardDigit + "*********" + lastFourDigits;
        System.out.println(cardNumberToDisplay);
        System.out.println("Card Number:" + cardNumber);
        System.out.println("Expiry Date:" + expiryDate);
        System.out.println("cvv:"+ cvv);
        System.out.println("Payment successful!Thank you for your order.");
    }

    @Override
    public String toString() {
            StringBuilder orderDetails = new StringBuilder();
            orderDetails.append("Thank you for dining with Slice-O-Heaven Pizzzeria.your order details are as follows:\n");
                for (String pizza : pizzaOrdered){
                    if (pizza!= null){
                        orderDetails.append(pizza + "\n");
                    }
                }
                orderDetails.append("ORDER TOTAL: €").append(totalOderPrice);
                return orderDetails.toString();


//        return "********RECEIPT********"+"\n"+
//                "Oder ID:"+ oderID +"\n"+
//                "Oder menu:"+ storeMenu+"\n"+
//                "Your side dish:"+sideDish+"\n"+
//                "Ingredients:" +ing1 + "," + ing2 + "," + ing3 + "\n" +
//                "Pizza Size:" + pizzaSize + "\n" +
//                "Pizza price:"+ pizzaPrice+"\n"+
//                "Extra Cheese:" + (extraCheese !=null ? "Yes" : "No") + "\n" +
//                "Drinks:" + drinks + "\n" +
//                "Half Payment:" + (wantDiscount !=null ? "Yes" : "No") + "\n" +
//                "Total oder:"+ oderTotal+"\n";
    }

}








