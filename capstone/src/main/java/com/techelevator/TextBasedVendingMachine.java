package com.techelevator;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class TextBasedVendingMachine implements VendingMachine {

    private Inventory inventory = new Inventory();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private double customerBalance = 0.00;

    @Override
    public void mainMenu() {
        //this method displays the main menu and asks them to make a choice 1-3 or hidden menu

        //instantiate a new TextBasedVendingMachine (which implements the VendingMachine interface)
        VendingMachine vendingMachine= new TextBasedVendingMachine();

        //ask customer to choose products
        System.out.println("");
        System.out.println("*** Main Menu ***");
        System.out.println("1) Display vending machine items");
        System.out.println("2) Make a purchase");
        System.out.println("3) Exit");
        System.out.println("Please enter a number: ");
        Scanner selectProductScanner = new Scanner(System.in);
        String productSelection = selectProductScanner.nextLine();

        //if 1, display products from TextBasedVendingMachine class
        //if 2, go to purchase menu
        //if 3, end program
        //if 4, hidden menu
        if(productSelection.equals("1")){
           displayProducts();  //invokes the displayProducts method below
            mainMenu(); //go back to this method
        } else if(productSelection.equals("2")){
            purchaseMenu();

        } else if(productSelection.equals("3")){
            System.out.println("TODO: end program");

        }else if(productSelection.equals("4")){
            System.out.println("TODO: hidden menu items go here");
        }else {
            System.out.println("Please enter a valid number");
        }
    }

    @Override
    public void displayProducts() {

        //displays welcome message and choices
        System.out.println("Products available");
        List<VendingItem> listOfItems = inventory.getVendingItems();
        for (int i = 0; i < listOfItems.size(); i++) {
            System.out.print(listOfItems.get(i).getCode() + " | ");
            System.out.print(listOfItems.get(i).getName() + " | ");
            System.out.print("$" + df.format(listOfItems.get(i).getPrice()) + " | ");
            System.out.println("Qty: " + listOfItems.get(i).getQuantity());
        }

    }

    @Override
    public void purchaseMenu() {
        //displays the purchase menu (feed money, select product, finish transaction, current money)
        System.out.println("");
        System.out.println("*** Purchase Menu ***");
        System.out.println("1) Feed Money into machine");
        System.out.println("2) Select a product");
        System.out.println("3) Finish Transaction");
        System.out.println("Current money added: $" + df.format(customerBalance));
        System.out.println("");
        System.out.println("Please enter your selection: ");

        //collect user input, assign to String variable
        Scanner purchaseMenuScanner = new Scanner(System.in);
        String purchaseMenuScannerStringInput = purchaseMenuScanner.nextLine();

        //Purchase menu choices
        if(purchaseMenuScannerStringInput.equals("1")){
            displayEnterBillsMessage();
        } else if(purchaseMenuScannerStringInput.equals("2")) {
            selectProduct();
        } else if(purchaseMenuScannerStringInput.equals("3")){
            finishTransaction();
        } else if(purchaseMenuScannerStringInput.equals("4")){
            System.out.println("TODO hidden menu");
        } else {
            //.err makes it print red
            System.err.println("please enter a valid number");
            purchaseMenu();
        }

    }

    @Override
    public void selectProduct(){
        //user selects an item that they want from the list of available products

        //show list of available products
        displayProducts();

        //ask them to pick one
        System.out.println("Enter the code for the item you'd like");
        Scanner pickProductScanner = new Scanner(System.in);
        String productSelection = pickProductScanner.nextLine();

        //create a new list to keep track of inventory items
        List<VendingItem> listOfItems = inventory.getVendingItems();

        //Defining variables will be used throughout this method
        boolean doesItemExist = false;
        int chosenIndex = 0;
        String chosenCode = null;
        double chosenPrice = 0.00;
        String chosenName = null;
        int chosenQuantity = 0;
        String chosenType = null;
        int i = 0;


        //does product code exist in the list?
        //if that item code is in the list, set the variables for that one item
        for(i = 0; i<listOfItems.size(); i++) {
            if (productSelection.equalsIgnoreCase(listOfItems.get(i).getCode())) {
                doesItemExist = true;
                chosenIndex = i;
                chosenPrice = listOfItems.get(i).getPrice();
                chosenCode = listOfItems.get(i).getCode();
                chosenQuantity = listOfItems.get(i).getQuantity();
                chosenName = listOfItems.get(i).getName();
                chosenType = listOfItems.get(i).getType();
            }
        }

                //If the item isn't found in the previous loop, the value for doesItemExist
                //will remain false. We'll tell them and make them go back to the
                //purchase menu
                if(doesItemExist == false){
                    System.out.println("That item code does not exist. Please try again");
                    purchaseMenu();
                }

                //do they have enough money for this item?
                //this wasn't in the ReadMe but seemed important to find out
                //if they don't, they go back to the purchase menu
                if(customerBalance < chosenPrice){
                    System.out.println("Please enter more money for that item");
                    purchaseMenu();
                }



                //if selected item is sold out, customer informed, returned to purchase menu
                //if it's not sold out, subtract 1 from the quantity
                //subtractQuantity method is from the VendingItem class
                if (chosenQuantity <= 0) {
                    System.out.println("This item is sold out");
                    purchaseMenu();
                } else {
                    listOfItems.get(chosenIndex).subtractQuantity(1);
                    displayProducts();
                }


                //valid product? dispense to customer (print item name, cost and money remaining)
                //setCustomerBalance is a setter at the end of this class
                setCustomerBalance(getCustomerBalance() - chosenPrice);
                System.out.println("Item dispensed: " + chosenName + " Item cost: $" + chosenPrice + " Current balance: $" + customerBalance);

                //also print silly message based on Object type
                if(chosenType.equals("Chips")){
                    System.out.println("Crunch Crunch, Yum!");
                } else if (chosenType.equals("Candy")){
                    System.out.println("Munch Munch, Yum!");
                } else if (chosenType.equals("Drink")){
                    System.out.println("Glug Glug, Yum!");
                } else if (chosenType.equals("Gum")){
                    System.out.println("Chew Chew, Yum!");
                }

                //after dispensing, return to purchase menu
                purchaseMenu();

    }

    @Override
    public void displayEnterBillsMessage() {
        //asks user to enter coins (need to change to bills)
        System.out.println("Please enter amount: (a) $1; (b) $5; (c) $10; (d) $20; (e) $50; (f) $100; (g) stop entering money");
        System.out.println("Current money added: $" + df.format(customerBalance));
        enterBills();
    }

    @Override
    public void enterBills() {
        //receives the bills entered by the user, calculate total amount inserted and figure out change

        //scanner to get input
        Scanner billsEnteredScanner = new Scanner(System.in);
        String billsEnteredInput = billsEnteredScanner.nextLine();

        //keep track of balance, display to customer
        if(billsEnteredInput.equalsIgnoreCase("a")){
            customerBalance += 1.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equalsIgnoreCase("b")){
            customerBalance += 5.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equalsIgnoreCase("c")){
            customerBalance += 10.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equalsIgnoreCase("d")){
            customerBalance += 20.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equalsIgnoreCase("e")){
            customerBalance += 50.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equalsIgnoreCase("f")){
            customerBalance += 100.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equalsIgnoreCase("g")){
            purchaseMenu();
        }

    }

    @Override
    public void displayChangeMessage() {

        //calculates total coins needed for change
        int cents = (int) (customerBalance * 100);
        int numQuarters = cents / 25;
        int numDimes    = (cents % 25) / 10;
        int numNickels  = ((cents % 25) % 10) / 5;
        int numPennies  = ((cents % 25) % 10) % 5;

        //displays total change to user
        System.out.println(numQuarters + " Quarters");
        System.out.println(numDimes    + " Dimes");
        System.out.println(numNickels  + " Nickels");
        System.out.println(numPennies  + " Pennies");

    }

    @Override
    public void finishTransaction(){

        //The customer's money is returned using nickels, dimes, and quarters (using the smallest amount of coins possible).
        System.out.println("");
        System.out.println("** Thanks for your purchase **");
        displayChangeMessage();

        //The machine's current balance must be updated to $0 remaining.
        customerBalance = 0;

        //After completing their purchase, the user is returned to the "Main" menu to continue using the vending machine.
        mainMenu();

    }

    //getters and setters
    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }
}
