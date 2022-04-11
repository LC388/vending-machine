package com.techelevator;

public class SimpleCalculator {

   // takes the coins from CoinBundle and figures out how to make change


    public double calculateTotal(CoinBundle enteredCoins) {
        //will return the money amount entered by the user
        return enteredCoins.getTotal();
    }


    public CoinBundle calculateChange(double customerBalance) {
        //return the minimum amount of coins to make the change
        CoinBundle change = new CoinBundle(new double[3]);

        //highest value
        double remainingAmount = customerBalance;

        change.number25CentCoins = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        change.number10CentCoins = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        change.number5CentCoins = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;


        return change;
    }
}
