package com.bank.service.impl;

import com.bank.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.bank.TestUtil.getBankAccount;

class BankServiceImplTest {

    @Test
    void acceptedWithdrawShouldUpdateBankAccountBalance(){
        BankServiceImpl bankServiceImpl = new BankServiceImpl();
        BankAccount bankAccount = getBankAccount();

        bankAccount.setBalance(1000d);
        double previousBalance = bankAccount.getBalance();

        double withdrawAmount = 250d;
        bankServiceImpl.withdraw(bankAccount, withdrawAmount);

        assertEquals(bankAccount.getBalance(),previousBalance-withdrawAmount,
                "Current balance should equal to previous balance minus withdraw Amoount");

        assertEquals(bankAccount.getPrevTrans(), -withdrawAmount,
                "Previous transaction should equal to (negative) withdraw amount");
    }

}