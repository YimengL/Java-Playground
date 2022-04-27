package com.example.controllers;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AccountController {

    private final TransferService transferService;

    @Autowired
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }


    /**
     * We use the HTTP POST method for the /transfer endpoint because it operates changes in the database's data.
     *
     * @param request   We use a request body to get the needed values (source account ID, destination account ID, and
     *                  amount to be transferred).
     */
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        // We call the service transferMoney() method, the transactional method that implements the transfer money use
        // case
        transferService.transferMoney(
                request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }
}
