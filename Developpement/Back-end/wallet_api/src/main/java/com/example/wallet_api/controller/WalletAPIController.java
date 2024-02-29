package com.example.wallet_api.controller;


import com.example.wallet_api.entity.Transaction;
import com.example.wallet_api.entity.Wallet;
import com.example.wallet_api.service.WalletService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/wallet")
@RestController
public class WalletAPIController {

    private final WalletService walletService;

    public WalletAPIController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Mono<Wallet> addWallet(@RequestBody Wallet wallet){
        return walletService.createWallet(wallet);
    }
    @GetMapping("/{userId}")
    public Mono<Wallet> getWalletByUserId(@PathVariable String userId){
        return walletService.getWalletByUserId(userId);
    }

    @PutMapping("/{userId}")
    public Mono<Wallet> makeTransaction(@PathVariable String userId, @RequestBody Transaction transaction){
        return walletService.makeTransaction(userId, transaction);
    }
}
