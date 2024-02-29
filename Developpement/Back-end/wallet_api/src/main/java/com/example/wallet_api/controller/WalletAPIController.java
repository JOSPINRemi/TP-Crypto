package com.example.wallet_api.controller;


import com.example.wallet_api.repository.WalletRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wallet")
@RestController
public class WalletAPIController {

    private final WalletRepository walletRepository;

    public WalletAPIController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }



}
