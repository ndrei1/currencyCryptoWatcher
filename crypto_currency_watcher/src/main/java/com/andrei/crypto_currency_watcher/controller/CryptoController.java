package com.andrei.crypto_currency_watcher.controller;

import com.andrei.crypto_currency_watcher.model.Crypto;
import com.andrei.crypto_currency_watcher.repository.CryptoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crypto")
public class CryptoController {

    private final CryptoRepository cryptoRepository;

    public CryptoController(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @GetMapping("{id}")
    public Double selectedCrypto(@PathVariable int id) {
        return cryptoRepository.findById(id).orElse(new Crypto()).getPrice_usd();
    }

    @GetMapping
    public String cryptoList() {
        return cryptoRepository.findAll().toString();
    }
}
