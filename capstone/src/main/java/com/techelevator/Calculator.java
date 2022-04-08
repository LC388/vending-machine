package com.techelevator;

public interface Calculator {

    int calculateTotal(CoinBundle enteredCoins);

    CoinBundle calculateChange(int amountMoneyToReturn);


}
