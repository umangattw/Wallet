package com.tw.wallet;

public class Money {
    public final double value;
    public final Currency currency;

    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money add(Money money) throws NegativeAmountException {
        if (isNegative(money))
            throw new NegativeAmountException();
        return new Money(productOfMoneyValueAndCurrencyValue(this) + productOfMoneyValueAndCurrencyValue(money), this.currency);
    }

    public Money withdrawal(Money money) throws NotEnoughBalanceException {
        if (notEnoughBalance(money))
            throw new NotEnoughBalanceException();
        return new Money(productOfMoneyValueAndCurrencyValue(this) - productOfMoneyValueAndCurrencyValue(money), this.currency);
    }

    private boolean notEnoughBalance(Money money) {
        return this.value < productOfMoneyValueAndCurrencyValue(money);
    }

    private boolean isNegative(Money money) {
        return money.value < 0;
    }

    private double productOfMoneyValueAndCurrencyValue(Money money) {
        return money.value * money.currency.value;
    }

}