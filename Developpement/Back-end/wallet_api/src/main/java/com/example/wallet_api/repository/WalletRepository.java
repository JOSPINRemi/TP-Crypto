package com.example.wallet_api.repository;

import com.example.wallet_api.entity.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WalletRepository extends ReactiveMongoRepository<Wallet, String> {

    Mono<Wallet> getByUserId(String userId);

}
