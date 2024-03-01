package com.example.wallet_api.controller;

import com.example.wallet_api.entity.Transaction;
import com.example.wallet_api.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Transaction> getTransactionById(@PathVariable String id){
        return transactionService.getTransactionById(id);
    }
}
