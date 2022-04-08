package com.techelevator;
import com.techelevator.Product;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Drink;
import com.techelevator.Gum;
import com.techelevator.VendingItem;
import com.techelevator.Inventory;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class TextBasedVendingMachine implements VendingMachine{

    private int selectedProduct; //for the selectProduct() method
    private CoinBundle change; //from enterCoins() method
    private Inventory inventory;


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
        System.out.println("Current money added: TODO add balance");
        System.out.println("");
        System.out.println("Please enter your selection: ");

        //collect user input, assign to int variable
        Scanner purchaseMenuScanner = new Scanner(System.in);
        String purchaseMenuScannerStringInput = purchaseMenuScanner.nextLine();
//        int purchaseMenuInput = Integer.parseInt(purchaseMenuScanner.nextLine());

        if(purchaseMenuScannerStringInput.equals("1")){
            System.out.println("TODO feed money");
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


    }

    @Override
    public void displayEnterCoinsMessage() {
        //asks user to enter coins (need to change to bills)
        System.out.println("Please enter the coins as follows: ");
        System.out.println("Number of 5 cent coins, number of 10 cent coins, number of 25 cent coins");
        System.out.println("");
        System.out.println("Example: if you would like to enter 2 dimes, 0, 2, 0");
        System.out.println("Please enter coins");

    }

    @Override
    public void enterCoins(int... coins) {
        //receives the coins entered by the user, calculate total amount inserted and figure out change

        //create SimpleCalculator object which implements Calculator interface
        Calculator calculator = new SimpleCalculator();

        //gets this from Product class
//        Product product = Product.valueOf(this.selectedProduct);

        //gets price
        int total = calculator.calculateTotal(new CoinBundle(coins));

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
}
