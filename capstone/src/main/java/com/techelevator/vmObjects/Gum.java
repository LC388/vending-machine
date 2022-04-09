package com.techelevator.vmObjects;

import com.techelevator.VendingItem;

public class Gum extends VendingItem {

    public Gum(String code, String name, String price, String type, String quantity) {
        super(code, name, price, type, quantity);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getSound() {
        // TODO Auto-generated method stub
        return "Chew Chew, Yum!";
    }
}