package com.tw.wallet;

public class NegativeAmountException extends Exception{
    public NegativeAmountException() {
        super("Negative Amount can't add to wallet");
    }
}
