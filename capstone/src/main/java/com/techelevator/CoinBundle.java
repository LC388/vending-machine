package com.techelevator;

//for returning change

public class CoinBundle {

    public double number5CentCoins;
    public double number10CentCoins;
    public double number25CentCoins;

    public CoinBundle(double... enteredCoins) {
        //assigns them to a spot in the enteredCoins array
        this.number5CentCoins = enteredCoins[0];
        this.number10CentCoins = enteredCoins[1];
        this.number25CentCoins = enteredCoins[2];
    }

    public double getTotal(){
        //total amount of coins amount
        double total = 0;
        total = total + this.number5CentCoins*5;
        total = total + this.number10CentCoins*10;
        total = total + this.number25CentCoins*25;
        return total;
    }
}
