package com.techelevator;

import com.techelevator.caught.SelectionException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.io.*;


public class TextBasedVendingMachineTest extends TestCase {

    TextBasedVendingMachine testMachine = new TextBasedVendingMachine();

    public void testMainMenu(){
        try{
           String productSelection = "r";

            // IMPORTANT: Save the old System.out!
            PrintStream old = System.out;

            // Create a stream to hold the output
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(new PrintStream(baos, false, "UTF-8"));

            // IMPORTANT: save old System.in!
            InputStream input = System.in;

            // Set new System.in
            System.setIn(new ByteArrayInputStream(productSelection.getBytes()));
            testMachine.mainMenu();



            // Put things back
            System.out.flush();
            System.setOut(old);

            //Restore
            System.setIn(input);


        }catch(IOException ioe){
            new IOException("i/o problem - test not executed\n");
        }
    }


    public void testPurchaseMenu() {
        //test for SelectionException

    }

    public void testSelectProduct() {
        //test if exceptions are thrown for invalid input
        //check for itemNotFoundException, outOfStockException, insufficientFundsException
        //does getSound() work?

    }

    public void testFinishTransaction() {
        //test that customerBalance = 0
        //we tested this in the calculator test class
    }


}