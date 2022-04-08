package com.techelevator;

//for returning change

public class CoinBundle {

    public int number5CentCoins;
    public int number10CentCoins;
    public int number25CentCoins;

    public CoinBundle(int... enteredCoins) {
        //assigns them to a spot in the enteredCoins array
        this.number5CentCoins = enteredCoins[0];
        this.number10CentCoins = enteredCoins[1];
        this.number25CentCoins = enteredCoins[2];
    }

    public int getTotal(){
        //total amount of coins amount
        int total = 0;
        total = total + this.number5CentCoins*5;
        total = total + this.number10CentCoins*10;
        total = total + this.number25CentCoins*25;
        return total;
    }
}
