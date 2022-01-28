package com.andrei.crypto_currency_watcher.controller;

import com.andrei.crypto_currency_watcher.model.Crypto;
import com.andrei.crypto_currency_watcher.model.User;
import com.andrei.crypto_currency_watcher.repository.CryptoRepository;
import com.andrei.crypto_currency_watcher.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final CryptoRepository cryptoRepository;

    public UserController(UserRepository userRepository, CryptoRepository cryptoRepository) {
        this.userRepository = userRepository;
        this.cryptoRepository = cryptoRepository;
    }

    @GetMapping("notify/{userName}/{symbol}")
    public String addCrypto(@PathVariable String userName, @PathVariable String symbol) {
        Crypto crypto = cryptoRepository.findBySymbol(symbol);
        userRepository.save(new User(userName,crypto,crypto.getPrice_usd()));
        return "added";
    }
}
