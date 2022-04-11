package com.techelevator;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(){
        super("code not found");
    }
}
