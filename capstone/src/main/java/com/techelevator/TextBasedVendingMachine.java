package com.techelevator;

import com.techelevator.caught.InsuffecientFundsException;
import com.techelevator.caught.ItemNotFoundException;
import com.techelevator.caught.OutOfStockException;
import com.techelevator.caught.SelectionException;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class TextBasedVendingMachine implements VendingMachine {

    private Inventory inventory = new Inventory();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private double customerBalance = 0.00;
    private MachineAudit addToLog = new MachineAudit();


    @Override
    public void mainMenu() {
        //this method displays the main menu and asks them to make a choice 1-3 or hidden menu


        try {
            //ask customer to choose products
            Scanner selectProductScanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("*** Main Menu ***");
            System.out.println("1) Display vending machine items");
            System.out.println("2) Make a purchase");
            System.out.println("3) Exit");
            System.out.println("Please enter a number: ");
            String productSelection = selectProductScanner.nextLine();

            //if 1, display products from TextBasedVendingMachine class
            //if 2, go to purchase menu
            //if 3, end program
            //if 4, hidden menu
            if (productSelection.equals("1")) {
                displayProducts();  //invokes the displayProducts method below
                mainMenu(); //go back to this method
            } else if (productSelection.equals("2")) {
                purchaseMenu();

            } else if (productSelection.equals("3")) {
                System.out.println("");
                System.out.println("*** Thank you for using the Vending Machine ***");
                System.exit(0);

            } else if (productSelection.equals("4")) {
                System.out.println("You've chosen the hidden sales report");
                SalesReport salesReport = new SalesReport(); //new SalesReport object
                salesReport.generateReport(); //go to the generateReport method in the Sales Report class
            } else {
                throw new SelectionException("Please enter a valid selection");
            }
        } catch (SelectionException e) {
            System.err.println(e.getMessage());
            mainMenu();
        }
    }

    @Override
    public void displayProducts() {

        //displays welcome message and choices
        System.out.println("Products available");
        List<VendingItem> listOfItems = inventory.getVendingItems();
        for (int i = 0; i < listOfItems.size(); i++) {
            System.out.print(listOfItems.get(i).getCode() + " | ");
            System.out.print(listOfItems.get(i).getName() + " | ");
            System.out.print("$" + df.format(listOfItems.get(i).getPrice()) + " | ");
            System.out.println("Qty: " + listOfItems.get(i).getQuantity());
        }

    }

    @Override
    public void purchaseMenu() {

        //displays the purchase menu (feed money, select product, finish transaction, current money)
        try {
            System.out.println("");
            System.out.println("*** Purchase Menu ***");
            System.out.println("1) Feed Money into machine");
            System.out.println("2) Select a product");
            System.out.println("3) Finish Transaction");
            System.out.println("");
            System.out.println("** Your current balance is: $" + df.format(customerBalance) + " **");
            System.out.println("");
            System.out.println("Please enter your selection: ");

            //collect user input, assign to String variable
            Scanner purchaseMenuScanner = new Scanner(System.in);
            String purchaseMenuScannerStringInput = purchaseMenuScanner.nextLine();

            //Purchase menu choices
            if (purchaseMenuScannerStringInput.equals("1")) {
                displayEnterBillsMessage();
            } else if (purchaseMenuScannerStringInput.equals("2")) {
                selectProduct();
            } else if (purchaseMenuScannerStringInput.equals("3")) {
                finishTransaction();
            } else if (purchaseMenuScannerStringInput.equals("4")) {
                System.out.println("TODO hidden menu");
            } else {
                throw new SelectionException("Please select a valid menu option");
            }

        } catch (SelectionException e) {
            System.err.println(e.getMessage());
            purchaseMenu();
        }
    }

    @Override
    public void selectProduct() {
        //user selects an item that they want from the list of available products

        //show list of available product


        //ask them to pick one
        boolean doWeNeedToTryAgain = false;

        do {
            try {
                displayProducts();
                List<VendingItem> listOfItems = inventory.getVendingItems();
                Scanner pickProductScanner = new Scanner(System.in);
                System.out.println("");
                System.out.println("Enter the code for the item you'd like");
                String productSelection = pickProductScanner.nextLine();
                //create a new list to keep track of inventory items


                //Defining variables will be used throughout this method


                //does product code exist in the list?
                //if that item code is in the list, set the variables for that one item
                for (VendingItem item : listOfItems) {
                    if (item.getCode().equalsIgnoreCase(productSelection)){
                        VendingItem chosen = item;
                        doWeNeedToTryAgain = false;
                        boolean doesItemExist = true;

                        //if selected item is sold out, customer informed, returned to purchase menu
                        //if it's not sold out, subtract 1 from the quantity
                        //subtractQuantity method is from the VendingItem class


                        //valid product? dispense to customer (print item name, cost and money remaining)
                        //setCustomerBalance is a setter at the end of this class
                        if (chosen.getQuantity() > 0) {
                            chosen.subtractQuantity(1);
                        } else {
                            throw new OutOfStockException("Sorry this item is out of stock, please select a new item.");

                        }

                        if (customerBalance > chosen.getPrice()) {
                            setCustomerBalance(customerBalance - chosen.getPrice());
                        } else {
                            throw new InsuffecientFundsException("Please insert more money to complete transaction");
                        }

                        if(!doesItemExist){
                            throw new ItemNotFoundException("Please select valid item");
                        }else {
                            System.out.println("");
                            System.out.println("*** Item dispensed ***");
                            System.out.println(chosen.getName() + " | Price: $" + df.format(chosen.getPrice()) + " | Current balance: $" + df.format(customerBalance));
                            System.out.println(chosen.getSound());
                            purchaseMenu();//if (customerBalance > chosen.getPrice()) {
                            // System.out.println("Please enter more money for that item");
                            //purchaseMenu();
                            //  }
                            //also print silly message based on Object type


                            //also write it to the log file
                            addToLog.logValidItemSelected(chosen.getName(), chosen.getCode(), chosen.getPrice(), customerBalance); //updates logFile

                            //after dispensing, return to purchase menu
                        }
                    }
                }
            } catch (InsuffecientFundsException e) {
                System.err.println(e.getMessage());
                purchaseMenu();
            } catch (OutOfStockException f) {
                System.err.println(f.getMessage());
                System.out.println("Enter the Code for the Item you'd like");
                doWeNeedToTryAgain = true;
            } catch (ItemNotFoundException g) {
                System.err.println(g.getMessage());
                doWeNeedToTryAgain = true;
            }
        }while (doWeNeedToTryAgain) ;
    }

            @Override
            public void displayEnterBillsMessage () {
                //asks user to enter coins (need to change to bills)
                System.out.println("Please enter amount: (a) $1; (b) $5; (c) $10; (d) stop entering money");
                System.out.println("");
                System.out.println("*** Current balance: $" + df.format(customerBalance) + " ***");
                enterBills();
            }

            @Override
            public void enterBills () {

                double feedMoneyValue = 0;

                //receives the bills entered by the user, calculate total amount inserted and figure out change

                //scanner to get input

                try{
                    Scanner billsEnteredScanner = new Scanner(System.in);
                    String billsEnteredInput = billsEnteredScanner.nextLine();

                    //keep track of balance, display to customer
                    if (billsEnteredInput.equalsIgnoreCase("a")) {
                        customerBalance += 1.0;
                        feedMoneyValue = 1.00; //updates logFile
                        addToLog.logFeedMoney(feedMoneyValue, customerBalance); //updates logFile
                        displayEnterBillsMessage();
                    } else if (billsEnteredInput.equalsIgnoreCase("b")) {
                        customerBalance += 5.0;
                        feedMoneyValue = 5.00; //updates logFile
                        addToLog.logFeedMoney(feedMoneyValue, customerBalance); //updates logFile
                        displayEnterBillsMessage();
                    } else if (billsEnteredInput.equalsIgnoreCase("c")) {
                        customerBalance += 10.0;
                        feedMoneyValue = 10.00; //updates logFile
                        addToLog.logFeedMoney(feedMoneyValue, customerBalance); //updates logFile
                        displayEnterBillsMessage();
                    } else if (billsEnteredInput.equalsIgnoreCase("d")) {
                        purchaseMenu();
                    } else {
                        throw new SelectionException("Please select a valid amount");
                    }

                } catch (SelectionException e){
                    System.err.println(e.getMessage());
                    displayEnterBillsMessage();
                    enterBills();
                }
            }

            @Override
            public void displayChangeMessage () {

                //write it to the log file
                addToLog.logChangeGiven(customerBalance); //updates logFile

                //calculates total coins needed for change
                int cents = (int) (customerBalance * 100);
                int numQuarters = cents / 25;
                int numDimes = (cents % 25) / 10;
                int numNickels = ((cents % 25) % 10) / 5;
                int numPennies = ((cents % 25) % 10) % 5;

                //displays total change to user
                System.out.println(numQuarters + " Quarters");
                System.out.println(numDimes + " Dimes");
                System.out.println(numNickels + " Nickels");
                System.out.println(numPennies + " Pennies");

            }

            @Override
            public void finishTransaction () {

                //The customer's money is returned using nickels, dimes, and quarters (using the smallest amount of coins possible).
                System.out.println("");
                System.out.println("** Thanks for your purchase **");
                System.out.println("******* Your change is *******");
                displayChangeMessage();

                //The machine's current balance must be updated to $0 remaining.
                customerBalance = 0;
                System.out.println("Your current balance is $0");

                //After completing their purchase, the user is returned to the "Main" menu to continue using the vending machine.
                mainMenu();
            }

            //getters and setters
            public double getCustomerBalance () {
                return customerBalance;
            }

            public void setCustomerBalance ( double customerBalance){
                this.customerBalance = customerBalance;
            }
        }
