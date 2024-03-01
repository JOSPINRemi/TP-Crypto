package com.example.wallet_api.service;

import com.example.wallet_api.entity.Transaction;
import com.example.wallet_api.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<Transaction> createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Mono<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }
}
