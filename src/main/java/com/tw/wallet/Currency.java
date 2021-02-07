package com.tw.wallet;

public enum Currency {
    Rupee(1) {
        public double balance(Money money) {
            return money.value / value;
        }
    }, Dollar(74.85) {
        @Override
        public double balance(Money money) {
            return money.value / value;
        }
    };

    public double value;

    Currency(double value) {
        this.value = value;
    }

    public abstract double balance(Money money);
}
