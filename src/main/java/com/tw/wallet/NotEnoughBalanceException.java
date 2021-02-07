package com.tw.wallet;

public class NotEnoughBalanceException extends Exception{
    public NotEnoughBalanceException() {
        super("Not enough Amount");
    }
}
