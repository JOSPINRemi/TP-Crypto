package com.example.wallet_api.repository;

import com.example.wallet_api.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {


}
