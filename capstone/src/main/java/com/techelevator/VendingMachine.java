package com.techelevator;

public interface VendingMachine {

    void displayProducts();

    void selectProduct(int product);

    //needs to change to enterBills
    void displayEnterCoinsMessage();

    //should change to enter bills
    void enterCoins(int... coins);

    void displayChangeMessage();
}
