package com.techelevator.vmObjects;

import com.techelevator.VendingItem;

public class Drink extends VendingItem {
    public Drink(String code, String name, String price, String type, String quantity) {
        super(code, name, price, type, quantity);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getSound() {
        // TODO Auto-generated method stub
        return "Glug Glug, Yum!";
    }
}