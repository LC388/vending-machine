package com.techelevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //welcome message
        System.out.println("******************************");
        System.out.println("Welcome to the Vending Machine");
        System.out.println("******************************");
        System.out.println();


        //call the main menu method from the TextBasedVending machine class
        VendingMachine vendingMachine = new TextBasedVendingMachine();
        vendingMachine.mainMenu();



//        //ask the user to select the product
//        System.out.println("  ");
//        System.out.println("  Please select your product: ");
//
//        //read product number selected by user
//        String selectedProduct = scanner.nextLine();
//        //needs to convert to integer currently, may not need this
//        int selectProductNumber = Integer.parseInt(selectedProduct);

        //product entered by the user
//        vendingMachine.selectProduct(selectProductNumber);

        //request coins - need to change this to bills
        //calls method from TextBasedVendingMachine class
//        Scanner scanner = new Scanner(System.in);
//        vendingMachine.displayEnterCoinsMessage();
//        String userEnteredCoins = scanner.nextLine();

        //convert String to array using method inside of Coin class
//        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);

        //pass coins entered into the vending machine
//        vendingMachine.enterCoins(enteredCoins);
//
//        //display change message
//        vendingMachine.displayChangeMessage();

    }


}
