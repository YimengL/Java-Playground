package com.example.controllers;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final TransferService transferService;

    @Autowired
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    /**
     * @param request   We get the sender and destination account IDs and the transferred amount in the HTTP request
     *                  body.
     */
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        // We call the service to execute the money transfer use case.
        transferService.transferMoney(request.getSenderAccountId(),
                request.getReceiverAccountId(), request.getAmount());
    }


    /**
     * We used an optional request parameter to get the name for which we want to return the account details.
     */
    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if (name == null) {
            // If no name is provided in the optional request parameter, we return all the account details.
            return transferService.getAllAccounts();
        } else {
            // if a name is provided in the request parameter, we only return the account details for the given name.
            return transferService.findAccountsByName(name);
        }
    }
}
