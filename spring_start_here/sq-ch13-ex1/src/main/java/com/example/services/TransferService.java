package com.example.services;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * We use the {@code @Transactional} annotation to instruct Spring to wrap the method's calls in transactions.
     */
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // We get the account's details to find the current amount in each account
        Account sender = accountRepository.findAccountByuId(idSender);
        Account receiver = accountRepository.findAccountByuId(idReceiver);

        // We calculate the new amount for the sender account.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // We set the new amount value for the sender account.
        accountRepository.changeAmount(idSender, senderNewAmount);

        // We set the new amount value for the receiver account.
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
