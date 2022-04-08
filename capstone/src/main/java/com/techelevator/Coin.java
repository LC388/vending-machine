package com.techelevator;

//changed to nickles dimes and quarters only

public enum Coin {
    FIVE_CENTS(5), TEN_CENTS(10), TWENTY_FIVE_CENTS(25);

    private int value;

    Coin (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int[] parseCoins(String coins){
        String[] numberCoinsInText = coins.split(",");
        int[] result = new int[numberCoinsInText.length];

        //loop through and convert to int
        for(int index = 0; index < numberCoinsInText.length; index++){
            result[index] = Integer.parseInt(numberCoinsInText[index]);
        }
        return result;
    }
}
