package com.example.services;

import com.example.exceptions.AccountNotFoundException;
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
     * We wrap the use case logic in a transaction to avoid data inconsistencies if any instruction fails.
     */
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        // We wrap the use case logic in a transaction to avoid data inconsistencies if any instruction fails.
        Account sender = accountRepository.findById(idSender).orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(AccountNotFoundException::new);

        // We calculate the new account amounts by subtracting the transferred value from the sender account and adding
        // it to the destination account.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // We change the accounts' amounts in the database.
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    /**
     * {@link AccountRepository} inherits this method from the Spring Data CrudRepository interface.
     */
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
