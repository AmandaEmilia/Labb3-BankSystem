package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Scanner;
import static com.bank.TestUtil.getBankAccount;

class BankMenuTest {

    @Test
    void shouldDeposit(){
        BankService bankServiceMock = Mockito.mock(BankService.class);
        BankAccount bankAccount = getBankAccount();
        Scanner scMock = Mockito.mock(Scanner.class);

        BankMenu bankMenu = new BankMenu(bankServiceMock, bankAccount, scMock);

        Mockito.when(scMock.next()).thenReturn("b","e");

        Mockito.when(scMock.nextDouble()).thenReturn(100d);

        bankMenu.menu();

        Mockito.verify(bankServiceMock, Mockito.times(1))
                .deposit(bankAccount, 100d);
    }

    @Test
    void shouldWithdraw(){
        BankService bankServiceMock = Mockito.mock(BankService.class);
        BankAccount bankAccount = getBankAccount();
        Scanner scMock = Mockito.mock(Scanner.class);

        BankMenu bankMenu = new BankMenu(bankServiceMock, bankAccount,scMock);

        Mockito.when(scMock.next()).thenReturn("c", "e");

        Mockito.when(scMock.nextDouble()).thenReturn(100d);

        bankMenu.menu();

        Mockito.verify(bankServiceMock, Mockito.times(1))
                .withdraw(bankAccount, 100d);
    }



}