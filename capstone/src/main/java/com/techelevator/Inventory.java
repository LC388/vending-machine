package com.techelevator;

import com.techelevator.vmObjects.Candy;
import com.techelevator.vmObjects.Chips;
import com.techelevator.vmObjects.Drink;
import com.techelevator.vmObjects.Gum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//this class gets the inventory items out of the csv file so the main class can display them


public class Inventory {
    private List<VendingItem> vendingItems;



    public Inventory() {

        vendingItems = new ArrayList<>();

        File newFile = new File("vendingmachine.csv");
        Scanner fileScanner;
        try {
            //this reads from vendingmachine.csv
            fileScanner = new Scanner(newFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); //reads everything in as a string
                String [] individualItems = line.split("\\|"); //split up that string

                String code = individualItems[0];
                String name = individualItems[1];
                String price = individualItems[2];
                String type = individualItems[3];

                //we always start at 5
                int quantity = 5;

                //make a new object out of each item based on their type
                if(type.equals("Chip")) {
                    vendingItems.add(new Chips(code, name, price, type, quantity));
                } else if (type.equals("Candy")) {
                    vendingItems.add(new Candy(code, name, price, type, quantity));
                } else if (type.equals("Drink")) {
                    vendingItems.add(new Drink(code, name, price, type, quantity));
                } else if (type.equals("Gum")) {
                    vendingItems.add(new Gum(code, name, price, type, quantity));
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found");
        }
    }

    public VendingItem getPurchaseItem(String code) {
        // If not exist
        return null;

    }

    public List<VendingItem> getVendingItems() {
        return vendingItems;
    }

    public void setVendingItems(List<VendingItem> vendingItems) {
        this.vendingItems = vendingItems;
    }
}
