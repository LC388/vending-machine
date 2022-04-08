package com.techelevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //instantiate a new TextBasedVendingMachine (which implements the VendingMachine interface)
        VendingMachine vendingMachine= new TextBasedVendingMachine();

        //invokes the displayProducts method from TextBasedVendingMachine class
        vendingMachine.displayProducts();

        //read product number selected by user
        String selectedProduct = scanner.nextLine();
        //needs to convert to integer currently, may not need this
        int selectProductNumber = Integer.parseInt(selectedProduct);

        //product entered by the user
        vendingMachine.selectProduct(selectProductNumber);

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
