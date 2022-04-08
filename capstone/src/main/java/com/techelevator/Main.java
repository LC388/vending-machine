package com.techelevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //instantiate a new TextBasedVendingMachine (which implements the VendingMachine interface)
        VendingMachine vendingMachine= new TextBasedVendingMachine();

        //welcome message
        System.out.println("******************************");
        System.out.println("Welcome to the Vending Machine");
        System.out.println("******************************");
        System.out.println();

        //ask customer to choose products
        System.out.println("Please press (1) to Display vending machine items, (2) to make a purchase, (3) to exit:");
        Scanner selectProductScanner = new Scanner(System.in);
        int productSelection = Integer.parseInt(selectProductScanner.nextLine());
        //if 1, display products from TextBasedVendingMachine class
        //if 2, go to purchase menu
        //if 3, end program
        if(productSelection == 1){
            vendingMachine.displayProducts();
        } else if(productSelection == 2){

        } else if(productSelection == 3){

        }else {
            System.out.println("Please enter a number");
        }




        //invokes the displayProducts method from TextBasedVendingMachine class
        vendingMachine.displayProducts();

        //read product number selected by user
        String selectedProduct = scanner.nextLine();
        //needs to convert to integer currently, may not need this
        int selectProductNumber = Integer.parseInt(selectedProduct);

        //product entered by the user
//        vendingMachine.selectProduct(selectProductNumber);

        //request coins - need to change this to bills
        //calls method from TextBasedVendingMachine class
        vendingMachine.displayEnterCoinsMessage();
        String userEnteredCoins = scanner.nextLine();

        //convert String to array using method inside of Coin class
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);

        //pass coins entered into the vending machine
        vendingMachine.enterCoins(enteredCoins);

        //display change message
        vendingMachine.displayChangeMessage();

    }
}
