package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TransferServiceUnitTests {

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() {
        // We use the Mockito mock() method to create mock instance for the AccountRepository object.
        AccountRepository accountRepository = mock(AccountRepository.class);

        // We create an instance of the TransferService object whose method we want to test. Instead of a real
        // AccountRepository instance, we create the object using a mock AccountRepository. This way, we replace the
        // dependency with something we can control.
        TransferService transferService = new TransferService(accountRepository);

        // We create the sender and the destination Account instances, which hold the Account details, which we assume
        // the app would find in the database.

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        // We control the mock's findById() method to return the sender account instance when it gets the sender account
        // ID. You can read this line as "If one calls the findById() method with the sender ID parameter, then return
        // the sender account instance."
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        // We control the mock's findById() method to return the destination account instance when it gets the
        // destination account ID. You can read this line as "If one calls the findById() method with destination ID
        // parameter, then return ths destination account instance."
        given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

        // We call the method we want to test with the sender ID, destination ID, and the value to be transferred.
        transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));

        // Verify that the changeAmount() method in the AccountRepository was called with the expected parameters.
        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }

}
