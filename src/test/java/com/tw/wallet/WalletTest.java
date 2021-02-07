package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void shouldAbleToAddBalance() throws NegativeAmountException {
        Wallet wallet = new Wallet();
        Money tenRupee = new Money(10, Currency.Rupee);
        wallet.add(tenRupee);

        assertEquals(10, wallet.balance(Currency.Rupee), 0.00001);
    }

    @Test
    void shouldThrowExceptionIfAmountIsNegative() {
        Wallet wallet = new Wallet();
        Money minusTenRupee = new Money(-10, Currency.Rupee);

        assertThrows(NegativeAmountException.class, () -> wallet.add(minusTenRupee));
    }

    @Test
    void shouldAbleToWithdrawalBalance() throws NotEnoughBalanceException, NegativeAmountException {
        Wallet wallet = new Wallet();
        Money tenRupee = new Money(10, Currency.Rupee);
        wallet.add(tenRupee);
        Money sixRupee = new Money(6, Currency.Rupee);

        wallet.withdrawal(sixRupee);

        assertEquals(4, wallet.balance(Currency.Rupee), 0.00001);
    }

    @Test
    void shouldThrowExceptionIfWithdrawalAmountIsGreaterThanTotalBalance() throws NegativeAmountException {
        Wallet wallet = new Wallet();
        Money sixRupee = new Money(6, Currency.Rupee);
        wallet.add(sixRupee);
        Money tenRupee = new Money(10, Currency.Rupee);

        assertThrows(NotEnoughBalanceException.class, () -> wallet.withdrawal(tenRupee));
    }

    @Test
    void shouldAbleToViewBalanceInRupees() throws NegativeAmountException {
        Wallet wallet = new Wallet();
        Money fiftyRupee = new Money(50, Currency.Rupee);
        Money oneDollar = new Money(1, Currency.Dollar);
        wallet.add(fiftyRupee);
        wallet.add(oneDollar);

        double balanceInRupees = wallet.balance(Currency.Rupee);

        assertEquals(124.85, balanceInRupees, .00001);
    }

    @Test
    void shouldAbleToViewBalanceInDollars() throws NegativeAmountException {
        Wallet wallet = new Wallet();
        Money seventyFourPointEightyFiveRupee = new Money(74.85, Currency.Rupee);
        Money oneHundredFortyNinePointSeven = new Money(149.7, Currency.Rupee);
        Money oneDollar = new Money(1, Currency.Dollar);

        wallet.add(seventyFourPointEightyFiveRupee);
        wallet.add(oneHundredFortyNinePointSeven);
        wallet.add(oneDollar);

        double balanceInDollar = wallet.balance(Currency.Dollar);

        assertEquals(4, balanceInDollar, .00001);
    }


}
