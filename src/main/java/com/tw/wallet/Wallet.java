package com.tw.wallet;

public class Wallet {
    private Money money = new Money(0.0, Currency.Rupee);


    public void add(Money money) throws NegativeAmountException {
        this.money = this.money.add(money);
    }

    public void withdrawal(Money money) throws NotEnoughBalanceException {
        this.money = this.money.withdrawal(money);
    }

    public double balance(Currency currencyType) {
        return currencyType.balance(money);
    }

}
