package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class TextBasedVendingMachine implements VendingMachine{

    private int selectedProduct; //for the selectProduct() method
    private CoinBundle change; //from enterCoins() method
    private Inventory inventory;
    private double customerBalance = 0.0;

    @Override
    public void mainMenu() {
        //this method displays the main menu and asks them to make a choice 1-3 or hidden menu

        //instantiate a new TextBasedVendingMachine (which implements the VendingMachine interface)
        VendingMachine vendingMachine= new TextBasedVendingMachine();

        //ask customer to choose products
        System.out.println("");
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

        //gets values from the getInventoryItems in the Product class
        this.inventory = new Inventory();
        List<VendingItem> listOfItems = inventory.getVendingItems();
        for (int i = 0; i < listOfItems.size(); i++) {
            System.out.print(listOfItems.get(i).getCode() + " | ");
            System.out.print(listOfItems.get(i).getName() + " | ");
            System.out.print("$" + listOfItems.get(i).getPrice() + " | ");
            System.out.println("Qty: " + listOfItems.get(i).getQuantity());
        }

    }

    @Override
    public void purchaseMenu() {
        //displays the purchase menu (feed money, select product, finish transaction, current money)
        System.out.println("");
        System.out.println("1) Feed Money into machine");
        System.out.println("2) Select a product");
        System.out.println("3) Finish Transaction");
        System.out.println("Current money added: " + customerBalance);
        System.out.println("");
        System.out.println("Please enter your selection: ");

        //collect user input, assign to int variable
        Scanner purchaseMenuScanner = new Scanner(System.in);
        String purchaseMenuScannerStringInput = purchaseMenuScanner.nextLine();
//        int purchaseMenuInput = Integer.parseInt(purchaseMenuScanner.nextLine());

        if(purchaseMenuScannerStringInput.equals("1")){
            displayEnterBillsMessage();
        } else if(purchaseMenuScannerStringInput.equals("2")){
            System.out.println("TODO select a product");
        } else if(purchaseMenuScannerStringInput.equals("3")){
            System.out.println("TODO finish transaction");
        } else if(purchaseMenuScannerStringInput.equals("4")){
            System.out.println("TODO hidden menu");
        } else {
            //.err makes it print red
            System.err.println("please enter a valid number");
            purchaseMenu();
        }

    }

    @Override
    public void selectProduct(String code) {
        //user selects an item that they want from the list of available products
        //show list of available products
        displayProducts();
        //ask them to pick one
        Scanner pickProductScanner = new Scanner(System.in);
        String productSelection = pickProductScanner.nextLine();

        //if code doesn't exist, customer is informed and returned to purchase menu


        //if sold out, customer informed, returned to purchase menu
        //valid product? dispensed to customer (prints item name, cost and money remaining)
        //after dispensed, update customerBalance and return to purchase menu
    }

    @Override
    public void displayEnterBillsMessage() {
        //asks user to enter coins (need to change to bills)
        System.out.println("Please enter amount: (a) $1; (b) $5; (c) $10; (d) $20; (e) $50; (f) $100; (g) stop entering money");
        System.out.println("Current money added: " + customerBalance);
        enterBills();
    }

    @Override
    public void enterBills() {
        //receives the bills entered by the user, calculate total amount inserted and figure out change

        //scanner to get input
        Scanner billsEnteredScanner = new Scanner(System.in);
        String billsEnteredInput = billsEnteredScanner.nextLine();

        if(billsEnteredInput.equals("a")){
            customerBalance += 1.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equals("b")){
            customerBalance += 5.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equals("c")){
            customerBalance += 10.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equals("d")){
            customerBalance += 20.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equals("e")){
            customerBalance += 50.0;
            displayEnterBillsMessage();
        }else if(billsEnteredInput.equals("f")){
            customerBalance += 100.0;
            displayEnterBillsMessage();
        } else if(billsEnteredInput.equals("g")){
            purchaseMenu();
        }

        //create SimpleCalculator object
        SimpleCalculator calculator = new SimpleCalculator();

        //gets this from Product class
//        Product product = Product.valueOf(this.selectedProduct);

        //gets price
//        int total = calculator.calculateTotal(new CoinBundle(coins));

        //total amount - price
//        int changeAmount = total - product.getPrice();
//        change = calculator.calculateChange(changeAmount);


    }

    @Override
    public void displayChangeMessage() {
        //displays a message letting the user know his change amount and coins.
        //.getTotal is from CoinBundle class
        System.out.println(" ");
        System.out.println("Your change is: "+ change.getTotal()+ "cents split as follows: ");
        System.out.println("   25 cent coins: "+ change.number25CentCoins);
        System.out.println("   10 cent coins: "+ change.number10CentCoins);
        System.out.println("   5  cent coins: "+ change.number5CentCoins);

    }

    //getters and setters
    public double getCustomerBalance() {
        return customerBalance;
    }

}
