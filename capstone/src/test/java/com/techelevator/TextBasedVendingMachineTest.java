package com.techelevator;

import com.techelevator.caught.SelectionException;
import junit.framework.TestCase;
import org.junit.Test;


public class TextBasedVendingMachineTest extends TestCase {


    @Test
    public void testMainMenuSelection() throws SelectionException {

        TextBasedVendingMachine testMachine = new TextBasedVendingMachine();

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