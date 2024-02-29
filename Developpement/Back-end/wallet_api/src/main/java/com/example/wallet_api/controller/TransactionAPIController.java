package com.example.wallet_api.controller;

import com.example.wallet_api.entity.Transaction;
import com.example.wallet_api.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionAPIController {

    private final TransactionService transactionService;
    public TransactionAPIController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

}
