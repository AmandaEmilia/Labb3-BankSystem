package com.bank.service.impl;

import com.bank.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.bank.TestUtil.getBankAccount;

class BankServiceImplTest {

    @Test
    void acceptedWithdrawShouldUpdateBankAccountBalance() {
        BankServiceImpl bankServiceImpl = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(1000d);
        double previousBalance = bankAccount.getBalance();

        double withdrawAmount = 250d;
        bankServiceImpl.withdraw(bankAccount, withdrawAmount);

        assertEquals(bankAccount.getBalance(), previousBalance - withdrawAmount,
                "Current balance should equal to previous balance minus withdraw Amoount");

        assertEquals(bankAccount.getPrevTrans(), -withdrawAmount,
                "Previous transaction should equal to (negative) withdraw amount");
    }

    @Test
    void declinedWithdrawShouldNotUpdateBankAccountBalance() {
        BankServiceImpl bankServiceImpl = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(750d);
        double previousBalance = bankAccount.getBalance();

        double withdrawAmount = 800d;
        bankServiceImpl.withdraw(bankAccount, withdrawAmount);

        assertEquals(bankAccount.getBalance(), previousBalance,
                "Should not update bank account balance");
    }

    @Test
    void depositShouldUpdateBankAccountBalance() {
        BankServiceImpl bankServiceImpl = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(750d);
        double previousBalance = bankAccount.getBalance();

        double depositAmount = 800d;
        bankServiceImpl.deposit(bankAccount, depositAmount);

        assertEquals(bankAccount.getBalance(), previousBalance + depositAmount,
                "Current balance should equal to previous balance plus deposit amount");

        assertEquals(bankAccount.getPrevTrans(), depositAmount,
                "Previous transaction should equal to deposit amount");
    }

}