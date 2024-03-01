package com.example.wallet_api.service;

import com.example.wallet_api.entity.Transaction;
import com.example.wallet_api.entity.Wallet;
import com.example.wallet_api.repository.WalletRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Mono<Wallet> createWallet(Wallet wallet){
        return walletRepository.save(wallet);
    }

    public Mono<Wallet> getWalletByUserId(String userId) {
        return walletRepository.getByUserId(userId);
    }

    public Mono<Wallet> makeTransaction(String userId, Transaction transaction) {
        return walletRepository.getByUserId(userId)
                .flatMap(wallet -> {
                    if (wallet.getTransactions() == null){
                        wallet.setTransactions(new ArrayList<>());
                    }
                    wallet.getTransactions().add(transaction);
                    return walletRepository.save(wallet);
                });
    }
}
