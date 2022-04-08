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

        System.out.println("Please press (1) to Display vending machine items, (2) to make a purchase, (3) to exit:");
        Scanner selectProductScanner = new Scanner(System.in);
        int productSelection = Integer.parseInt(selectProductScanner.nextLine());

        //if 1, display products from TextBasedVendingMachine class
        //if 2, go to purchase menu
        //if 3, end program
        //if 4, hidden menu
        if(productSelection == 1){
           displayProducts();  //invokes the displayProducts method below
            mainMenu(); //go back to this method
        } else if(productSelection == 2){
            System.out.println("TODO: go to purchase menu");

        } else if(productSelection == 3){
            System.out.println("TODO: end program");

        }else if(productSelection == 4){
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
            System.out.print(listOfItems.get(i).getCode() + "| ");
            System.out.print(listOfItems.get(i).getName() + "| ");
            System.out.print(listOfItems.get(i).getPrice() + "| ");
            System.out.println(listOfItems.get(i).getQuantity());
        }


//        for(Product product: Product.values()){
//            System.out.println("    " + product.getId()+ " " + product.name()+" - Price: " + product.getPrice());
//        }

    }

    @Override
    public void selectProduct(String code) {


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
