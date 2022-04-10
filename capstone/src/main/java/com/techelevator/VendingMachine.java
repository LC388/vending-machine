package com.techelevator;

public interface VendingMachine {

    //displays the main menu and asks them to make a choice 1-3 or hidden menu
    void mainMenu();

    //gets the items from the csv file and lists them
    void displayProducts();

    //displays the purchase menu (feed money, select product, finish transaction, current money)
    void purchaseMenu();

    //user selects an item that they want from the list of available products
    void selectProduct();

    //message display to enter money
    void displayEnterBillsMessage();

    //should change to enter bills
    void enterBills();

    void displayChangeMessage();
}
