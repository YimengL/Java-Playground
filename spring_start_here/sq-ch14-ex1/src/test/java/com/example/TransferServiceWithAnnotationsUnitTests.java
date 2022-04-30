package com.example;


import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Enable the use of {@code @Mock} and {@code @InjectMocks} annotations.
 */
@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

    // Use the @Mock annotation to create a mock object and inject it into the test class's annotated field.
    @Mock
    private AccountRepository accountRepository;

    // Use the @InjectMocks to create the tested object and inject it into the class's annotated field.
    @InjectMocks
    private TransferService transferService;


    @Test
    public void moneyTransferHappyFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }


    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        // We control the mock AccountRepository to return an empty Optional when the findById() method is called for
        // the destination account.
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        // We assert that the method throws an AccountNotFoundException in the given scenario
        assertThrows(AccountNotFoundException.class,
                () -> transferService.transferMoney(1, 2, new BigDecimal(100)));

        // We use the verify() method with the never() conditional to assert that the changeAmount() method hasn't been
        // called
        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}
