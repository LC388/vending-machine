package com.techelevator;

import com.techelevator.caught.SelectionException;
import com.techelevator.vmItems.Chips;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest extends TestCase {
    Calculator testCalculator = new Calculator();

    @Test(expected = SelectionException.class)
    //checks to see if selectionexception is thrown
    public void testFigureCustomerBalanceAfterBillInput() {
    Assertions.assertThrows(SelectionException.class, () ->{
        testCalculator.figureCustomerBalanceAfterBillInput("r");
        });
    }

    public void testFigureFeedMoneyValueFromEnterBillsInput() {
        //test this one
    }

    public void testFigureCustomerBalanceMinusChosenPrice() {
        //test this one
    }

}