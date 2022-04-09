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





    }


}
